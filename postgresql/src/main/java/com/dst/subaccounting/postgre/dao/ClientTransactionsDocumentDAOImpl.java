package com.dst.subaccounting.postgre.dao;

import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.ClientTransactionsDocumentMapper;
import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class ClientTransactionsDocumentDAOImpl extends GenericDAOImpl <ClientTransactionsDocument> {
	
	public ClientTransactionsDocumentDAOImpl() {
		super("id", "ClientTransaction", new ClientTransactionsDocument().getClass(), new ClientTransactionsDocumentMapper());
	}

	public List<ClientTransactionsDocument> getTransactionToProcess(){
		String tableName = this.tableName;
		RowMapper<ClientTransactionsDocument> rowMapper = this.rowMapper;

		return jdbcTemplate.query("select * from "+ tableName +" WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", rowMapper);

	}
}
