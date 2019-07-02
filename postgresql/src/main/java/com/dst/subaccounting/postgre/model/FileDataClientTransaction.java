package com.dst.subaccounting.postgre.model;

import java.util.List;

import com.dst.subaccounting.postgre.dao.FileData;

import lombok.Data;

@Data
public class FileDataClientTransaction implements FileData {
	
	public static String getTableName() {
		return "ClientTransaction";
	}
	
	public FileDataClientTransaction(ClientTransaction ct) {
	    setClearingFirmNumber(ct.getClearingFirmNumber());
	    setDealerFirmNumber(ct.getDealerFirmNumber());
	    setAgentForFirm(ct.getAgentForFirm());
	    setBin(ct.getBin());
	    setFundId(ct.getFundId()); // Reference to _id field within security master
	    setCusip(ct.getCusip());
	    setExchangetoCusip(ct.getExchangetoCusip());
	    setNsccControlNumber(ct.getNsccControlNumber());
	    setNsccCorrectionIndicator(ct.getNsccCorrectionIndicator());
	    setCurrencyIndicator(ct.getCurrencyIndicator());
	    setPrice(ct.getPrice());
	    setDistributionEventType(ct.getDistributionEventType());
	    setDistributionRecordDate(ct.getDistributionRecordDate());
	    setTradeDate(ct.getTradeDate()); // Would be date field
	    setSubmissionDate(ct.getSubmissionDate());
	    setTransactionRecievedDate(ct.getTransactionRecievedDate());
	    setTransactionRecievedTime(ct.getTransactionRecievedTime());
	    setAnticipatedSettlementDate(ct.getAnticipatedSettlementDate());
	    setNsccSettlementOverrideReasonCode(ct.getNsccSettlementOverrideReasonCode());
	    setTransactionStatus(ct.getTransactionStatus());
	    setWorkedCd(ct.getWorkedCd());
	    setPriceProtected(ct.getPriceProtected());
	    setContingentDeferredSalesChargeLiquidationIndicator(ct.getContingentDeferredSalesChargeLiquidationIndicator());
	    setLiquidationIndicator529(ct.getLiquidationIndicator529());
	    setNavReasonCode(ct.getNavReasonCode());
	    setSalesChargeRate(ct.getSalesChargeRate());
	    setDiscountCategory(ct.getDiscountCategory());
	    setNsccRoaLoiValue(ct.getNsccRoaLoiValue());
	    setActualRoaValueSource(ct.getActualRoaValueSource());
	    setLoiNumber(ct.getLoiNumber());
	    setShortTermRedemptionFeeRate(ct.getShortTermRedemptionFeeRate());
	    setShortTermRedemptionFeeShareAmount(ct.getShortTermRedemptionFeeShareAmount());
	    setShortTermRedemptionFeeMoneyAmount(ct.getShortTermRedemptionFeeMoneyAmount());
	    setContingentDeferredSalesChargeMoneyAmount(ct.getContingentDeferredSalesChargeMoneyAmount());
	    setMoneyMarketLiquidityFeeRate(ct.getMoneyMarketLiquidityFeeRate());
	    setMoneyMarketLiquidtyFeeMoneyAmount(ct.getMoneyMarketLiquidtyFeeMoneyAmount());
	    setTaxIdNumber(ct.getTaxIdNumber());
	    setTaxIdType(ct.getTaxIdType());
	    setBranch(ct.getBranch());
	    setRepresentativeName(ct.getRepresentativeName());
	    setRepresentativeNumber(ct.getRepresentativeNumber());
	    setStateOfSale(ct.getStateOfSale());
	    setCountryCode(ct.getCountryCode());
	    setSocialCode(ct.getSocialCode());
	    setMoneyMarketLiquidityFeeRedemptionGateIndicator(ct.getMoneyMarketLiquidityFeeRedemptionGateIndicator());
	    setMoneyMarketAggregatedOrderIndicator(ct.getMoneyMarketAggregatedOrderIndicator());
	    setDerivedBusinessProcessingGroup(ct.getDerivedBusinessProcessingGroup());
	    setNsccTransactionType(ct.getNsccTransactionType());
	    setNsccTransactionCode(ct.getNsccTransactionCode());
	    setNsccOriginalControlNumber(ct.getNsccOriginalControlNumber());
	    setNsccOriginalCorrectionIndicator(ct.getNsccOriginalCorrectionIndicator());
	    setNsccTestIndicator(ct.getNsccTestIndicator());
	    setNsccAsofIndicator(ct.getNsccAsofIndicator());
	    setAsofReasonCode(ct.getAsofReasonCode());
	    setNsccCustomerName(ct.getNsccCustomerName());
	    setNsccFundAccountIndicator(ct.getNsccFundAccountIndicator());
	    setNsccBookPhysicalShareIndicator(ct.getNsccBookPhysicalShareIndicator());
	    setNsccRelatedTradeIndicator(ct.getNsccRelatedTradeIndicator());
	    setAssetTypeIndicator(ct.getAssetTypeIndicator());
	    setNsccFractionIndicator(ct.getNsccFractionIndicator());
	    setGrossNetSettlementIndicator(ct.getGrossNetSettlementIndicator());
	    setNsccSecurityIssueType(ct.getNsccSecurityIssueType());
	    setNsccFundParticipantNumberCd(ct.getNsccFundParticipantNumberCd());
	    setNsccOmnibusAccountIndicatorCd(ct.getNsccOmnibusAccountIndicatorCd());
	    setNsccProgramTransactionIndicatorCd(ct.getNsccProgramTransactionIndicatorCd());
	    setNsccPeriodicFrequencyIndicatorCd(ct.getNsccPeriodicFrequencyIndicatorCd());
	    setOrderNumber(ct.getOrderNumber());
	    setNsccAcatsControlNumber(ct.getNsccAcatsControlNumber());
	    setNsccAcatsAssetsSequenceId(ct.getNsccAcatsAssetsSequenceId());
	    setFirmRoleInTransfer(ct.getFirmRoleInTransfer());
	    setOriginatingFirmNumber(ct.getOriginatingFirmNumber());
	    setOriginatingAgentForFirm(ct.getOriginatingAgentForFirm());
	    setOriginatingBIN(ct.getOriginatingBIN());
	    setOriginatingFundAccount(ct.getOriginatingFundAccount());
	    setOriginatingAccountOmnibusIndicator(ct.getOriginatingAccountOmnibusIndicator());
	    setDestinationBIN(ct.getDestinationBIN());
	    setDestinationFundAccount(ct.getDestinationFundAccount());
	    setDestinationAccountOmnibusIndicator(ct.getDestinationAccountOmnibusIndicator());
	    setAsofPaymentDate(ct.getAsofPaymentDate());
	    setNsccRegistrationStatusCode(ct.getNsccRegistrationStatusCode());
	    setNsccRequestStatusCode(ct.getNsccRequestStatusCode());
	}

	public FileDataClientTransaction() {
	}

	private Integer clientTransactionId;
    private int clearingFirmNumber;
    private int dealerFirmNumber;
    private String agentForFirm;
    private String bin;
    private String fundId; // Reference to _id field within security master
    private String cusip;
    private String exchangetoCusip;
    private String nsccControlNumber;
    private String nsccCorrectionIndicator;
    private String currencyIndicator;
    private double price;
    private String distributionEventType;
    private String distributionRecordDate;
    private String tradeDate; // Would be date field
    private String submissionDate;
    private String transactionRecievedDate;
    private String transactionRecievedTime;
    private String anticipatedSettlementDate;
    private String nsccSettlementOverrideReasonCode;
    private String transactionStatus;
    private String workedCd;
    private String priceProtected;
    private String contingentDeferredSalesChargeLiquidationIndicator;
    private String liquidationIndicator529;
    private String navReasonCode;
    private double salesChargeRate;
    private String discountCategory;
    private String nsccRoaLoiValue;
    private String actualRoaValueSource;
    private String loiNumber;
    private double shortTermRedemptionFeeRate;
    private double shortTermRedemptionFeeShareAmount;
    private double shortTermRedemptionFeeMoneyAmount;
    private double contingentDeferredSalesChargeMoneyAmount;
    private double moneyMarketLiquidityFeeRate;
    private double moneyMarketLiquidtyFeeMoneyAmount;
    private String taxIdNumber;
    private String taxIdType;
    private String branch;
    private String representativeName;
    private int representativeNumber;
    private String stateOfSale;
    private String countryCode;
    private String socialCode;
    private String moneyMarketLiquidityFeeRedemptionGateIndicator;
    private String moneyMarketAggregatedOrderIndicator;
    private String derivedBusinessProcessingGroup;
    private String nsccTransactionType;
    private String nsccTransactionCode;
    private String nsccOriginalControlNumber;
    private String nsccOriginalCorrectionIndicator;
    private String nsccTestIndicator;
    private String nsccAsofIndicator;
    private String asofReasonCode;
    private String nsccCustomerName;
    private String nsccFundAccountIndicator;
    private String nsccBookPhysicalShareIndicator;
    private String nsccRelatedTradeIndicator;
    private String assetTypeIndicator;
    private String nsccFractionIndicator;
    private String grossNetSettlementIndicator;
    private String nsccSecurityIssueType;
    private String nsccFundParticipantNumberCd;
    private String nsccOmnibusAccountIndicatorCd;
    private String nsccProgramTransactionIndicatorCd;
    private String nsccPeriodicFrequencyIndicatorCd;
    private String orderNumber;
    private String nsccAcatsControlNumber;
    private String nsccAcatsAssetsSequenceId;
    private String firmRoleInTransfer;
    private String originatingFirmNumber;
    private String originatingAgentForFirm;
    private String originatingBIN;
    private String originatingFundAccount;
    private String originatingAccountOmnibusIndicator;
    private String destinationBIN;
    private String destinationFundAccount;
    private String destinationAccountOmnibusIndicator;
    private String asofPaymentDate;
    private String nsccRegistrationStatusCode;
    private String nsccRequestStatusCode;
}
