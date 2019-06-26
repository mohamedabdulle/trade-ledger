package com.dst.subaccounting.postgre.dao;

import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.ClientTransactionsDocumentMapper;
import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;

@Repository
public class ClientTransactionsDocumentDAOImpl extends GenericDAOImpl <ClientTransactionsDocument> {
	
	public ClientTransactionsDocumentDAOImpl() {
		super("id", "ClientTransaction", new ClientTransactionsDocument().getClass(), new ClientTransactionsDocumentMapper());
	}
	
}
