package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.model.TransactionDialog;
import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.ClientTransactionExtractor;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientTransactionDAOImpl extends GenericDAOImpl <ClientTransaction> {
	
	public ClientTransactionDAOImpl() {
		super("clientTransactionId", ClientTransaction.getTableName(), new ClientTransaction().getClass(), new ClientTransactionExtractor());
	}

	public List<ClientTransaction> getTransactionToProcess(){
		return jdbcTemplate.query("select " + ClientTransaction.getTableName() + ", "  + TransactionDialog.getTableName() +" from "+ tableName +" join "+ TransactionDialog.getTableName() + " on TransactionDialog.transactionDialogId in transactionDialogIds WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", clientTransactionExtractor);
	}

	public void generateInsertStatement(List<String> fieldNames) {

		insertStatement = "INSERT INTO " + ClientTransaction.getTableName() +
				"(" + fieldNames.stream().collect(Collectors.joining(", ")) +
				") values(" + fieldNames.stream().map(f -> ":" + f).collect(Collectors.joining(", ")) + ")";
		System.out.println(insertStatement);
	}

	public void generateDeleteStatement(){
		deleteStatement = "DELETE FROM " + ClientTransaction.getTableName() + " WHERE " + ClientTransaction.getTableName() + "." + tableId + " = :" + tableId;
	}

	public void generateDeleteAllStatement() {
		deleteAllStatement = "DELETE FROM " + ClientTransaction.getTableName();
	}
}
