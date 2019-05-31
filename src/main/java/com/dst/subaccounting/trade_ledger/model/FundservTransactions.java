package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clientTransactions")
public class FundservTransactions {
	
	@Field("529liquidationindicator")
	private String LiquidationIndicator529;

	@Field("accrualearningsstartstopdate")
	private String accrualEarningsStartStopDate;

	@Field("actualroavalue")
	private String actualRoaValue;

	@Field("actualroavaluesource")
	private String actualRoaValueSource;

	@Field("advancedcommissionamount")
	private int advancedCommissionAmount;

	@Field("aggregated")
	private boolean aggregated;

	@Field("allsharetransaction")
	private boolean allShareTransaction;

	@Field("anticipatedsettlementdate")
	private String anticipatedSettlementDate; // should be date

	@Field("asofpaymentdate")
	private String asofPaymentDate;// should be date

	@Field("asofreasoncode")
	private String asofReasonCode;

	@Field("assettypeindicator")
	private String assetTypeIndicator;

	@Field("associatedoperationsaccount")
	private String associatedOperationsAccount;

	@Field("associatedreconciliationadjustmenttype")
	private String associatedReconciliationAdjustmentType;

	@Field("contingentdeferredsaleschargeliquidationindicator")
	private String contingentDeferredSalesChargeLiquidationIndicator;

	@Field("contingentdeferredsaleschargemoneyamount")
	private String contingentDeferredSalesChargeMoneyAmount; // Idk whether this should be string

	@Field("cumulativediscountnumber")
	private int cumulativeDiscountNumber;

	@Field("derivedbusinessprocessinggroup")
	private String derivedBusinessProcessingGroup;

	@Field("destinationbin")
	private String destinationBIN;

	@Field("discountcategory")
	private String discountCategory;

	@Field("excessivetraderviolation")
	private boolean excessiveTraderViolation;

	@Field("exchangetofund_id")
	private String ExchangeToFund_id;

	@Field("exchangetosecurityid")
	private String ExchangeToSecurityId;

	@Field("exchangetosymbol")
	private String ExchangeToSymbol;

	@Field("excludedfromaggregation")
	private boolean excludedFromAggregation;

	@Field("externalcontrolnumber")
	private int externalControlNumber;

	@Field("firmcommissionamount")
	private double firmCommissionAmount;

	@Field("firmcommissionrate")
	private double firmCommissionRate;

	@Field("frontendcommissionamount")
	private double frontEndCommissionAmount;

	@Field("grossnetsettlementindicator")
	private String grossNetSettlementIndicator;

	@Field("loinumber")
	private String loiNumber;

	@Field("moneymarketaggregatedorderindicator")
	private String moneyMarketAggregatedOrderIndicator;

	@Field("moneymarketliquidityfeerate")
	private double moneyMarketLiquidityFeeRate;

	@Field("moneymarketliquidityfeeredemptiongateindicator")
	private String moneyMarketLiquidityFeeRedemptionGateIndicator;

	@Field("moneymarketliquidtyfeemoneyamount")
	private double moneyMarketLiquidtyFeeMoneyAmount;

	@Field("navreasoncode")
	private String navReasonCode;

	@Field("nsccasofindicator")
	private String nsccAsofIndicator;

	@Field("nscccontrolnumber")
	private String nsccControlNumber;

	@Field("nscccorrectionindicator")
	private String nsccCorrectionIndicator;

	@Field("nsccfractionindicator")
	private String nsccFractionIndicator;

	@Field("nsccfundaccountindicator")
	private String nsccFundAccountIndicator;

	@Field("nsccfundparticipantnumber")
	private String nsccFundParticipantNumber;

	@Field("nsccmemofield")
	private String nsccMemoField;

	@Field("nsccoriginalcontrolnumber")
	private String nsccOriginalControlNumber;

	@Field("nsccoriginalcorrectionindicator")
	private String nsccOriginalCorrectionIndicator;

	@Field("nsccperiodicfrequencyindicator")
	private String nsccPeriodicFrequencyIndicator;

	@Field("nsccprogramtransactionindicator")
	private String nsccProgramTransactionIndicator;

	@Field("nsccregistrationstatuscode")
	private String nsccRegistrationStatusCode;

	@Field("nsccrelatedtradeindicator")
	private String nsccRelatedTradeIndicator;

	@Field("nsccrequeststatuscode")
	private String nsccRequestStatusCode;

	@Field("nsccsettlementoverridereasoncode")
	private String nsccSettlementOverrideReasonCode;

	@Field("nscctransactioncode")
	private String nsccTransactionCode;

	@Field("nscctransactiontype")
	private String nsccTransactionType;

	@Field("omnibustradetransmitted")
	private boolean omnibusTradeTransmitted;

	@Field("originatingbin")
	private String originatingBIN;

	@Field("priceprotected")
	private boolean priceProtected;

	@Field("redemptionfeeindicator")
	private String redemptionFeeIndicator;

	@Field("roaloivalue")
	private String roaLoiValue;

	@Field("saleschargerate")
	private double salesChargeRate;

	@Field("shorttermredemptionfeemoneyamount")
	private double shortTermRedemptionFeeMoneyAmount;

	@Field("shorttermredemptionfeerate")
	private double shortTermRedemptionFeeRate;

	@Field("shorttermredemptionfeeshareamount")
	private double shortTermRedemptionFeeShareAmount;

	@Field("shorttermredemptionfeewaiverreasoncode")
	private String shortTermRedemptionFeeWaiverReasonCode;

	@Field("socialcode")
	private String socialCode;

	@Field("transactionreceiveddate")
	private String transactionReceivedDate; // should be date

	@Field("transactionreceivedtime")
	private String transactionReceivedTime; // Should be time

	@Field("underwritercommissionamount")
	private double underwriterCommissionAmount;

	@Field("worked")
	private boolean worked;
}
