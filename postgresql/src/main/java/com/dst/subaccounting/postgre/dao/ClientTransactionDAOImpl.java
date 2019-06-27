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
		super("id", "ClientTransaction", new ClientTransaction().getClass(), new ClientTransactionExtractor());
	}

	public List<ClientTransaction> getTransactionToProcess(){
		return jdbcTemplate.query("select " + tableName + ", "  + TransactionDialog.tableName +" from "+ tableName +" join "+ TransactionDialog.tableName + " on TransactionDialog.transactionDialogId in transactionDialogIds WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", clientTransactionExtractor);
	}

	public void generateInsertStatement(List<String> fieldNames) {

		insertStatement = "INSERT INTO " + tableName +
				"(" + fieldNames.stream().collect(Collectors.joining(", ")) +
				") values(" + fieldNames.stream().map(f -> ":" + f).collect(Collectors.joining(", ")) + ")";
	}

	public void generateDeleteStatement(){
		deleteStatement = "DELETE FROM " + tableName + " WHERE " + tableName + "." + tableId + " = :" + tableId;
	}

	public void generateDeleteAllStatement() {
		deleteAllStatement = "DELETE FROM " + tableName;
	}
}
