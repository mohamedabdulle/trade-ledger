package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.model.TransactionDialog;
import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.FileData;
import com.dst.subaccounting.postgre.mapper.ClientTransactionExtractor;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import com.dst.subaccounting.postgre.model.FileDataClientTransaction;
import com.dst.subaccounting.postgre.model.FileDataRejectDialog;
import com.dst.subaccounting.postgre.model.FileDataTransactionDialog;
import com.dst.subaccounting.postgre.model.RejectDialog;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ClientTransactionDAOImpl extends GenericDAOImpl <ClientTransaction> {
	
	private String tdInsertStatement;
	private String rdInsertStatement;
	
	public ClientTransactionDAOImpl() {
		super("clientTransactionId", ClientTransaction.getTableName(), new ClientTransactionExtractor());
		
	}

	public List<ClientTransaction> getTransactionToProcess(){
		return jdbcTemplate.query("select " + ClientTransaction.getTableName() + ", "  + TransactionDialog.getTableName() +" from "+ tableName +" join "+ TransactionDialog.getTableName() + " on TransactionDialog.transactionDialogId in transactionDialogIds WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", resultSetExtractor);
	}

	protected void generateInsertStatement() {
		List<String> fieldNames = generateFieldNames(new FileDataClientTransaction().getClass(), tableId);
		insertStatement = generateInsertStatement(ClientTransaction.getTableName(), fieldNames);
		
		generateTdInsertStatement();
		generateRdInsertStatement();
	}

	private void generateTdInsertStatement() {
		List<String> fieldNames = generateFieldNames(new FileDataTransactionDialog().getClass(), "transactionDialogId");
		tdInsertStatement = generateInsertStatement(TransactionDialog.getTableName(), fieldNames); 
	}
	
	private void generateRdInsertStatement() { 
		List<String> fieldNames = generateFieldNames(new FileDataRejectDialog().getClass(), "rejectDialogId");
		rdInsertStatement = generateInsertStatement(RejectDialog.getTableName(), fieldNames);
	}
	
	private List<String> generateFieldNames(Class<?> cls, String id) {
		return Stream.of(cls.getDeclaredFields())
//		.filter(f-> f.getType() != List.class)
		.map(Field::getName).filter(f -> f != id)
		.collect(Collectors.toList());
	}
	
	private String generateInsertStatement(String tableName, List<String> fieldNames) {
		return "INSERT INTO " + tableName + "(" + fieldNames.stream().collect(Collectors.joining(", ")) + ") values (" + 
				fieldNames.stream().map(f -> ":" + f).collect(Collectors.joining(", ")) + ")";
	}
	
	protected void generateDeleteStatement() {
		deleteStatement = "DELETE FROM " + ClientTransaction.getTableName() + " WHERE " + ClientTransaction.getTableName() + "." + tableId + " = :" + tableId;
	}

	protected void generateDeleteAllStatement() {
		deleteAllStatement = "DELETE FROM " + ClientTransaction.getTableName();
	}

	protected void generateGetAllStatement() {
		getAllStatement = "select * from ClientTransaction"
				+ " left join TransactionDialog on TransactionDialog.ClientTransactionId = ClientTransaction.ClientTransactionId"
				+ " left join RejectDialog on RejectDialog.ClientTransactionId = ClientTransaction.ClientTransactionId";
	}
	@Override
	public void insert(ClientTransaction ct) {
		FileDataClientTransaction fdct = new FileDataClientTransaction(ct);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(fdct);
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(insertStatement, namedParameters, keyHolder);
		Integer ctId = (Integer)keyHolder.getKeys().get(tableId.toLowerCase());
		
		List<TransactionDialog> tdList = ct.getTransactionDialogs();
		if(tdList != null && tdList.size() != 0) {
			List<FileDataTransactionDialog> fdtdList = tdList.parallelStream().map(td -> new FileDataTransactionDialog(td, ctId)).collect(Collectors.toList());
			insertDialogs(fdtdList, ctId, tdInsertStatement);			
		}
		
		List<RejectDialog> rdList = ct.getRejectDialogs();
		if(rdList != null && rdList.size() != 0 ) {
			List<FileDataRejectDialog> fdrdList = rdList.parallelStream().map(rd -> new FileDataRejectDialog(rd, ctId)).collect(Collectors.toList());
			insertDialogs(fdrdList, ctId, rdInsertStatement);			
		}
	}
	
	/**
	 * insert TransactionDialog(s) or RejectDialog(s) into their table
	 * @param tdList the list of transaction dialogs to insert
	 * @param ctId the id of the client transaction associated with the transaction dialogs to insert
	 */
	private void insertDialogs(List<? extends FileData> dialogList, Integer ctId, String insertStatement) {
		if(dialogList.size() == 1) {
			BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dialogList.get(0));
		
			jdbcTemplate.update(insertStatement, namedParameters);
		}
		else {
			SqlParameterSource[] namedParameterList = SqlParameterSourceUtils.createBatch(dialogList);
			jdbcTemplate.batchUpdate(insertStatement, namedParameterList);
		}
	}
}
