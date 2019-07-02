package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.model.TransactionDialog;
import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.ClientTransactionExtractor;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import com.dst.subaccounting.postgre.model.FileDataClientTransaction;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ClientTransactionDAOImpl extends GenericDAOImpl <ClientTransaction> {
	
	private String tdInsertStatement;
	
	public ClientTransactionDAOImpl() {
		super("clientTransactionId", ClientTransaction.getTableName(), new ClientTransactionExtractor());
		
	}

	public List<ClientTransaction> getTransactionToProcess(){
		return jdbcTemplate.query("select " + ClientTransaction.getTableName() + ", "  + TransactionDialog.getTableName() +" from "+ tableName +" join "+ TransactionDialog.getTableName() + " on TransactionDialog.transactionDialogId in transactionDialogIds WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", clientTransactionExtractor);
	}

	protected void generateInsertStatement() {
		List<String> fieldNames = generateFieldNames(new FileDataClientTransaction().getClass(), tableId);
		insertStatement = generateInsertStatement(ClientTransaction.getTableName(), fieldNames);
		
		generateTdInsertStatement();
		System.out.println(insertStatement);
	}

	private void generateTdInsertStatement() {
		List<String> fieldNames = generateFieldNames(new TransactionDialog().getClass(), "transactionDialogId");
		tdInsertStatement = generateInsertStatement(TransactionDialog.getTableName(), fieldNames); 
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

	@Override
	public void insert(ClientTransaction ct) {
		List<TransactionDialog> tdList = ct.getTransactionDialogs();
		System.out.println(tdList);
		Integer tdId = insertTransactionDialog(tdList.get(0));
		
		System.out.println(tdId);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ct);
		
		List<Integer> tdIdList = new ArrayList<Integer>();
		tdIdList.add(tdId);
		
		FileDataClientTransaction fdct = new FileDataClientTransaction(ct, tdIdList, null);
		namedParameters = new BeanPropertySqlParameterSource(fdct);
		
		jdbcTemplate.update(insertStatement, namedParameters);
	}
	
	/**
	 * insert a transaction dialog
	 * @param td
	 * @return the id of the transaction dialog inserted
	 */
	private Integer insertTransactionDialog(TransactionDialog td) { 
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(td);
		
		jdbcTemplate.update(tdInsertStatement, namedParameters, keyHolder);
	
		return (Integer) keyHolder.getKeyList().get(0).get("TransactionDialogId".toLowerCase());
	}
}
