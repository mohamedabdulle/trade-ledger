package com.dst.subaccounting.postgre.dao;

import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.ClientTransactionsDocumentMapper;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class ClientTransactionsDocumentDAOImpl extends GenericDAOImpl <ClientTransaction> {
	
	public ClientTransactionsDocumentDAOImpl() {
		super("id", "ClientTransaction", new ClientTransaction().getClass(), new ClientTransactionsDocumentMapper());
	}

	public List<ClientTransaction> getTransactionToProcess(){
		String tableName = this.tableName;
		RowMapper<ClientTransaction> rowMapper = this.rowMapper;

		return jdbcTemplate.query("select * from "+ tableName +" WHERE price IS NOT NULL AND transactionStatus != 'C' ORDER BY tradeDate DESC", rowMapper);

	}
}
