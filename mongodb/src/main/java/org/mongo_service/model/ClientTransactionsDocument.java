package org.mongo_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "clientTransactions")
public class ClientTransactionsDocument {
    
    @Id
    private ObjectId id;
    private Long actualPostingDate;
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
    private String submissionDate;
    private String symbol;
    private String tradeDate; // Would be date field
    private String transactionCategory;
    private String transactionSource;
    private String transactionStatus;
    private String transactionSubType;
    private String transactionType;
    private String transactionUserId;
    private DistributionTransactions distributionTransactions;
    private Comments comments;
    
    public String toString() {
    	return ReflectionToStringBuilder.toString(this);
    }
}
