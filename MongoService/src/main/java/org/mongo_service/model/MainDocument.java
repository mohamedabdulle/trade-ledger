package org.mongo_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
@Document(collection = "mainDocument")
public class MainDocument {

	@Id
	private String id;

	@Field("actualpostingdate")
	private Long actualPostingDate;

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
	private String currencyIndicator;

	@Field("dealerfirmnumber")
	private int dealerFirmNumber;

	@Field("effectonbalancer")
	private String effectOnBalance;

	@Field("fund_id")
	private String fund_id; // Reference to _id field within security master document

	@Field("moneyamount")
	private String moneyAmount;

	@Field("omnibustransaction_Id")
	private String omnibusTransaction_Id; // Reference to "_id" from omnibus

	@Field("price")
	private double price;

	@Field("representativename")
	private String representativeName;

	@Field("representativenumber")
	private int representativeNumber;

	@Field("securityid")
	private String securityId;

	@Field("sequenceid")
	private String sequenceId;

	@Field("sharequantity")
	private String shareQuantity;

	@Field("stateofsale")
	private String stateOfSale;

	@Field("submissiondate")
	private String submissionDate;

	@Field("symbol")
	private String symbol;

	@Field("tradedate")
	private String tradeDate; // Would be date field

	@Field("transactioncategory")
	private String transactionCategory;

	@Field("transactionsource")
	private String transactionSource;

	@Field("transactionstatus")
	private String transactionStatus;

	@Field("transactionsubtype")
	private String transactionSubType;
	
	@Field("transactiontype")
	private String transactionType;
	
	@Field("transactionuserid")
	private String transactionUserId;
}
