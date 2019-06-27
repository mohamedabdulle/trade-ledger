package com.dst.subaccounting.postgre.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.dst.subaccounting.postgre.model.ClientTransaction;
import com.dst.subaccounting.postgre.model.RejectDialog;
import com.dst.subaccounting.postgre.model.TransactionDialog;

public final class ClientTransactionExtractor implements ResultSetExtractor<List<ClientTransaction>> {

	@Override
	public List<ClientTransaction> extractData(ResultSet rs) throws SQLException {
		Map<Integer, ClientTransaction> ctMap = new HashMap<>();
		
		while (rs.next()) {
			Integer ctId = rs.getInt("clientTransactionsDocumentId");
			
			ClientTransaction ctDoc = ctMap.get(ctId);

			//initialize new doc if it doesn't exist
			if (ctDoc == null) {
				ctDoc = makeClientTransactionsDocument(rs);
				ctMap.put(ctId, ctDoc);
			}
			
			//add dialogs to existing client Transaction doc
			ctDoc.getTransactionDialogs().add(makeTransactionDialog(rs));
			ctDoc.getRejectDialogs().add(makeRejectDialog(rs));
		}
		
		return ctMap.values().stream().collect(Collectors.toList());		
	}
	
	//TO DO
	private ClientTransaction makeClientTransactionsDocument(ResultSet rs) throws SQLException {
		ClientTransaction ct = new ClientTransaction();
		Integer id = rs.getInt("clientTransactionsDocumentId");
		ct.setClientTransactionId(id);
		
		return ct;
	}
	
	//TO DO
	private TransactionDialog makeTransactionDialog(ResultSet rs) throws SQLException {
		TransactionDialog td = new TransactionDialog();
		Integer id = rs.getInt("transactionDialogId");
		td.setTransactionDialogId(id);
		
		return td;
	}
	
	//TO DO
	private RejectDialog makeRejectDialog(ResultSet rs) throws SQLException {
		return new RejectDialog();
	}

}