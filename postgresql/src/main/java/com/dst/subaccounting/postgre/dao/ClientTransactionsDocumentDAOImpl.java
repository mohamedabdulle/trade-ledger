package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.mapper.ClientTransactionsDocumentMapper;
import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;

public class ClientTransactionsDocumentDAOImpl extends GenericDAOImpl <ClientTransactionsDocument> {
	
	public ClientTransactionsDocumentDAOImpl() {
		super("id", "ClientTransaction", new ClientTransactionsDocument().getClass(), new ClientTransactionsDocumentMapper());
	}
	
}
