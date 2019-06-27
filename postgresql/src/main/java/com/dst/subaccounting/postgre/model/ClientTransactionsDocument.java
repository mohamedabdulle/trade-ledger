package com.dst.subaccounting.postgre.model;

import java.sql.Date;
import java.util.List;


import lombok.Data;

@Data
public class ClientTransactionsDocument {

    private int clearingFirmNumber;
    private int dealerFirmNumber;
    private String agentForFirm;
    private String bin;
    private String fundId; // Reference to _id field within security master
    private String 	cusip;
    private String 	exchangetoCusip;
    private String 	nsccControlNumber;
    private String 	nsccCorrectionIndicator;
    private String currencyIndicator;
    private double price;
    private String 	distributionEventType;
    private String 	distributionRecordDate;
    private Date tradeDate; // Would be date field
    private Date submissionDate;
    private String 	transactionRecievedDate;
    private String 	transactionRecievedTime;
    private String 	anticipatedSettlementDate;
    private String 	nsccSettlementOverrideReasonCode;
    private String transactionStatus;
    private String 	workedCd;
    private String 	priceProtected;
    private String 	contingentDeferredSalesChargeLiquidationIndicator;
    private String 	liquidationIndicator529;
    private String 	navReasonCode;
    private double 	salesChargeRate;
    private String 	discountCategory;
    private String 	nsccRoaLoiValue;
    private String 	actualRoaValueSource;
    private String 	loiNumber;
    private double 	shortTermRedemptionFeeRate;
    private double 	shortTermRedemptionFeeShareAmount;
    private double 	shortTermRedemptionFeeMoneyAmount;
    private double 	contingentDeferredSalesChargeMoneyAmount;
    private double 	moneyMarketLiquidityFeeRate;
    private double 	moneyMarketLiquidtyFeeMoneyAmount;
    private String 	taxIdNumber;
    private String 	taxIdType;
    private String branch;
    private String representativeName;
    private int representativeNumber;
    private String stateOfSale;
    private String countryCode;
    private String 	socialCode;
    private String 	moneyMarketLiquidityFeeRedemptionGateIndicator;
    private String 	moneyMarketAggregatedOrderIndicator;
    private String 	derivedBusinessProcessingGroup;
    private String 	nsccTransactionType;
    private String 	nsccTransactionCode;
    private String 	nsccOriginalControlNumber;
    private String 	nsccOriginalCorrectionIndicator;
    private String 	nsccTestIndicator;
    private String 	nsccAsofIndicator;
    private String 	asofReasonCode;
    private String 	nsccCustomerName;
    private String 	nsccFundAccountIndicator;
    private String 	nsccBookPhysicalShareIndicator;
    private String 	nsccRelatedTradeIndicator;
    private String 	assetTypeIndicator;
    private String 	nsccFractionIndicator;
    private String 	grossNetSettlementIndicator;
    private String 	nsccSecurityIssueType;
    private String 	nsccFundParticipantNumberCd;
    private String 	nsccOmnibusAccountIndicatorCd;
    private String 	nsccProgramTransactionIndicatorCd;
    private String 	nsccPeriodicFrequencyIndicatorCd;
    private String 	orderNumber;
    private String 	nsccAcatsControlNumber;
    private String 	nsccAcatsAssetsSequenceId;
    private String 	firmRoleInTransfer;
    private String 	originatingFirmNumber;
    private String 	originatingAgentForFirm;
    private String 	originatingBIN;
    private String 	originatingFundAccount;
    private String 	originatingAccountOmnibusIndicator;
    private String 	destinationBIN;
    private String 	destinationFundAccount;
    private String 	destinationAccountOmnibusIndicator;
    private String 	asofPaymentDate;
    private String 	nsccRegistrationStatusCode;
    private String 	nsccRequestStatusCode;
    
//    private List<TransactionDialog> transactionDialogs;
//    private List<RejectDialog> rejectDialogs;
}
