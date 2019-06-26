package com.dst.subaccounting.postgre.mapper;

import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTransactionsDocumentMapper implements RowMapper<ClientTransactionsDocument> {

	@Override
	public ClientTransactionsDocument mapRow(ResultSet resultSet, int i) throws SQLException {
		ClientTransactionsDocument doc = new ClientTransactionsDocument();
		 
	    doc.setActualPostingDate(resultSet.getDate("actualPostingDate"));
	    doc.setAgentForFirm(resultSet.getString("agentForFirm"));
	    doc.setAnticipatedPostingDate(resultSet.getString("anticipatedPostingDate"));
	    doc.setBin(resultSet.getString("bin"));
	    doc.setBranch(resultSet.getString("branch"));
	    doc.setClearingFirmNumber(resultSet.getInt("clearingFirmNumber"));
	    doc.setCountryCode(resultSet.getString("countryCode"));
	    doc.setCurrencyIndicator(resultSet.getString("currencyIndicator"));
	    doc.setDealerFirmNumber(resultSet.getInt("dealerFirmNumber"));
	    doc.setEffectOnBalance(resultSet.getString("effectOnBalance"));
	    doc.setFund_id(resultSet.getString("fund_id")); // Reference to _id field within security master
	    doc.setMoneyAmount(resultSet.getString("moneyAmount"));
	    doc.setOmnibusTransaction_Id(resultSet.getString("omnibusTransaction_Id")); // Reference to "_id" from omnibus
	    doc.setPrice(resultSet.getDouble("price"));
	    doc.setRepresentativeName(resultSet.getString("representativeName"));
	    doc.setRepresentativeNumber(resultSet.getInt("representativeNumber"));
	    doc.setSecurityId(resultSet.getString("securityId"));
	    doc.setSequenceId(resultSet.getString("sequenceId"));
	    doc.setShareQuantity(resultSet.getString("shareQuantity"));
	    doc.setStateOfSale(resultSet.getString("stateOfSale"));
	    doc.setSubmissionDate(resultSet.getString("submissionDate"));
	    doc.setSymbol(resultSet.getString("symbol"));
	    doc.setTradeDate(resultSet.getString("tradeDate")); // Would be date field
	    doc.setTransactionCategory(resultSet.getString("transactionCategory"));
	    doc.setTransactionSource(resultSet.getString("transactionSource"));
	    doc.setTransactionStatus(resultSet.getString("transactionStatus"));
	    doc.setTransactionSubType(resultSet.getString("transactionSubType"));
	    doc.setTransactionType(resultSet.getString("transactionType"));
	    doc.setTransactionUserId(resultSet.getString("transactionUserId"));
		
		return doc;
	}
}
