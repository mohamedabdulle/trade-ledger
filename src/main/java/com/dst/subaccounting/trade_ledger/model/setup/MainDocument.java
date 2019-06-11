package com.dst.subaccounting.trade_ledger.model.setup;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class MainDocument {

	@JsonAlias("actualpostingdate")
	@Field("actualpostingdate")
	private String actualPostingDate;

	@JsonAlias("agentforfirm")
	@Field("agentforfirm")
	private String agentForFirm;

	@JsonAlias("anticipatedpostingdate")
	@Field("anticipatedpostingdate")
	private String anticipatedPostingDate;

	@JsonAlias("bin")
	@Field("bin")
	private String bin;

	@JsonAlias("clearingfirmnumber")
	@Field("clearingfirmnumber")
	private int clearingFirmNumber;

	@JsonAlias("countrycode")
	@Field("countrycode")
	private String countryCode;

	@JsonAlias("currencyindicator")
	@Field("currencyindicator")
	private String currencyIndicator;

	@JsonAlias("dealerfirmnumber")
	@Field("dealerfirmnumber")
	private int dealerFirmNumber;

	@JsonAlias("effectonbalancer")
	@Field("effectonbalancer")
	private String effectOnBalance;

	@JsonAlias("fund_id")
	@Field("fund_id")
	private String fund_id; // Reference to _id field within security master
							// document

	@JsonAlias("moneyamount")
	@Field("moneyamount")
	private String moneyAmount;

	@JsonAlias("omnibustransaction_Id")
	@Field("omnibustransaction_Id")
	private String omnibusTransaction_Id; // Reference to "_id" from omnibus

	@JsonAlias("price")
	@Field("price")
	private double price;

	@JsonAlias("representativename")
	@Field("representativename")
	private String representativeName;

	@JsonAlias("representativenumber")
	@Field("representativenumber")
	private int representativeNumber;

	@JsonAlias("securityid")
	@Field("securityid")
	private String securityId;

	@JsonAlias("sequenceid")
	@Field("sequenceid")
	private String sequenceId;

	@JsonAlias("sharequantity")
	@Field("sharequantity")
	private String shareQuantity;

	@JsonAlias("stateofsale")
	@Field("stateofsale")
	private String stateOfSale;

	@JsonAlias("submissiondate")
	@Field("submissiondate")
	private String submissionDate;

	@JsonAlias("symbol")
	@Field("symbol")
	private String symbol;

	@JsonAlias("tradedate")
	@Field("tradedate")
	private String tradeDate; // Would be date field

	@JsonAlias("transactioncategory")
	@Field("transactioncategory")
	private String transactionCategory;

	@JsonAlias("transactionsource")
	@Field("transactionsource")
	private String transactionSource;

	@JsonAlias("transactionstatus")
	@Field("transactionstatus")
	private String transactionStatus;

	@JsonAlias("transactionsubtype")
	@Field("transactionsubtype")
	private String transactionSubType;

	@JsonAlias("transactiontype")
	@Field("transactiontype")
	private String transactionType;

	@JsonAlias("transactionuserid")
	@Field("transactionuserid")
	private String transactionUserId;
}
