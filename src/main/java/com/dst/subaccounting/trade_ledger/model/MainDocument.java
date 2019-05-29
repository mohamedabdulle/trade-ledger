package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class MainDocument {

	@Id
	private String id;
	
	@Field("actualpostingdate")
	private String actualPostingDate;
	
	@Field("agentforfirm")
	private String agentForFirm;
	
	@Field("anticipatedpostingdate")
	private String anticipatedPostingDate;
	
	@Field("bin")
	private String bin;
	
	@Field("clearingfirmnumber")
	private int clearingFirmNumber;
	
	@Field("countrycode")
	private String countryCode;
	
	@Field("currencyindicator")
	public String currencyIndicator;
	
	@Field("dealerfirmnumber")
	public int dealerFirmNumber;
	
	@Field("effectonbalancer")
	public String effectOnBalance;
	
	@Field("fund_id")
	public String fund_id; //Reference to _id field within security master document
	
	@Field("moneyamount")
	public String moneyAmount;
	
	@Field("omnibustransaction_Id")
	public String omnibusTransaction_Id; //Reference to "_id" from omnibus
	
	@Field("price")
	public double price;
	
	@Field("representativename")
	public String representativeName;
	
	@Field("representativenumber")
	public int representativeNumber;
	
	@Field("securityid")
	public String securityId;
	
	@Field("sequenceid")
	public String sequenceId;
	
	@Field("sharequantity")
	public String shareQuantity;
	
	@Field("stateofsale")
	public String stateOfSale;
	
	@Field("submissiondate")
	public String submissionDate;
	
	@Field("symbol")
	public String symbol;
	
	@Field("tradedate")
	public String tradeDate; //Would be date field
	
	@Field("transactioncategory")
	public String transactionCategory;
	
	@Field("transactionsource")
	public String transactionSource;
	
	@Field("transactionstatus")
	public String transactionStatus;
	
	@Field("transactionsubtype")
	public String transactionSubType;
	
	@Field("transactiontype")
	public String transactionType;
	
	@Field("transactionuserid")
	public String transactionUserId;
}
