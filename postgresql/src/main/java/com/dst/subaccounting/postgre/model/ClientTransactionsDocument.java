package com.dst.subaccounting.postgre.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ClientTransactionsDocument {

    private String id;
    private Date actualPostingDate;
    private String agentForFirm;
    private String anticipatedPostingDate;
    private String bin;
    private String branch;
    private int clearingFirmNumber;
    private String countryCode;
    private String currencyIndicator;
    private int dealerFirmNumber;
    private String effectOnBalance;
    private String fund_id; // Reference to _id field within security master
    private String moneyAmount;
    private String omnibusTransaction_Id; // Reference to "_id" from omnibus
    private double price;
    private String representativeName;
    private int representativeNumber;
    private String securityId;
    private String sequenceId;
    private String shareQuantity;
    private String stateOfSale;
    private Date submissionDate;
    private String symbol;
    private Date tradeDate; // Would be date field
    private String transactionCategory;
    private String transactionSource;
    private String transactionStatus;
    private String transactionSubType;
    private String transactionType;
    private String transactionUserId;
    private DistributionTransactions distributionTransactions;
    private Comment comment;
}
