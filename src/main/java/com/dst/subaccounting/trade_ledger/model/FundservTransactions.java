package com.dst.subaccounting.trade_ledger.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")

public class FundservTransactions {
	@Field("529liquidationindicator")
	public String LiquidationIndicator529;
	
	@Field("accrualearningsstartstopdate")
	public String accrualEarningsStartStopDate;
	
	@Field("actualroavalue")
	public String actualRoaValue;
	
	@Field("actualroavaluesource")
	public String actualRoaValueSource;
	
	@Field("advancedcommissionamount")
	public int advancedCommissionAmount;
	
	@Field("aggregated") 
	public boolean aggregated ;

	@Field("allsharetransaction")
	public boolean allShareTransaction;

	@Field("anticipatedsettlementdate")
	public String anticipatedSettlementDate; //should be date
	
	@Field("asofpaymentdate")
	public String asofPaymentDate;//should be date
	
	@Field("asofreasoncode")
	public String asofReasonCode;
	
	@Field("assettypeindicator")
	public String assetTypeIndicator;
	
	@Field("associatedoperationsaccount")
	public String associatedOperationsAccount;
	
	@Field("associatedreconciliationadjustmenttype") 
	public String associatedReconciliationAdjustmentType;

	@Field("contingentdeferredsaleschargeliquidationindicator")
	public String contingentDeferredSalesChargeLiquidationIndicator;
	
	@Field("contingentdeferredsaleschargemoneyamount")
	public String contingentDeferredSalesChargeMoneyAmount; //Idk whether this should be string
	
	@Field("cumulativediscountnumber")
	public int cumulativeDiscountNumber;
	
	@Field("derivedbusinessprocessinggroup")
	public String derivedBusinessProcessingGroup;
	
	@Field("destinationbin")
	public String destinationBIN;
	
	@Field("discountcategory")
	public String discountCategory;
	
	@Field("excessivetraderviolation") 
	public boolean excessiveTraderViolation;

	@Field("exchangetofund_id")
	public String ExchangeToFund_id;
	
	@Field("exchangetosecurityid")
	public String ExchangeToSecurityId; 
	
	@Field("exchangetosymbol")
	public String ExchangeToSymbol;
	
	@Field("excludedfromaggregation")
	public boolean excludedFromAggregation;
	
	@Field("externalcontrolnumber")
	public int externalControlNumber;
	
	@Field("firmcommissionamount")
	public double firmCommissionAmount;
	
	@Field("firmcommissionrate") 
	public double firmCommissionRate;

	@Field("frontendcommissionamount")
	public double frontEndCommissionAmount;
	
	@Field("grossnetsettlementindicator") 
	public String grossNetSettlementIndicator;

	@Field("loinumber")
	public String loiNumber;
	
	@Field("moneymarketaggregatedorderindicator")
	public String moneyMarketAggregatedOrderIndicator; 
	
	@Field("moneymarketliquidityfeerate")
	public double moneyMarketLiquidityFeeRate;
	
	@Field("moneymarketliquidityfeeredemptiongateindicator")
	public String moneyMarketLiquidityFeeRedemptionGateIndicator;
	
	@Field("moneymarketliquidtyfeemoneyamount")
	public double moneyMarketLiquidtyFeeMoneyAmount;
	
	@Field("navreasoncode")
	public String navReasonCode;
	
	@Field("nsccasofindicator") 
	public String nsccAsofIndicator;

	@Field("nscccontrolnumber")
	public String nsccControlNumber;
	
	@Field("nscccorrectionindicator")
	public String nsccCorrectionIndicator;
	
	@Field("nsccfractionindicator")
	public String nsccFractionIndicator;
	
	@Field("nsccfundaccountindicator")
	public String nsccFundAccountIndicator;
	
	@Field("nsccfundparticipantnumber")
	public String nsccFundParticipantNumber;
	
	@Field("nsccmemofield") 
	public String nsccMemoField;

	@Field("nsccoriginalcontrolnumber")
	public String nsccOriginalControlNumber;
	
	@Field("nsccoriginalcorrectionindicator")
	public String nsccOriginalCorrectionIndicator;
	
	@Field("nsccperiodicfrequencyindicator")
	public String nsccPeriodicFrequencyIndicator;
	
	@Field("nsccprogramtransactionindicator")
	public String nsccProgramTransactionIndicator;
	
	@Field("nsccregistrationstatuscode")
	public String nsccRegistrationStatusCode;
	
	@Field("nsccrelatedtradeindicator") 
	public String nsccRelatedTradeIndicator;

	@Field("nsccrequeststatuscode")
	public String nsccRequestStatusCode;
	
	@Field("nsccsettlementoverridereasoncode")
	public String nsccSettlementOverrideReasonCode;
	
	@Field("nscctransactioncode")
	public String nsccTransactionCode;
	
	@Field("nscctransactiontype")
	public String nsccTransactionType;
	
	@Field("omnibustradetransmitted")
	public boolean omnibusTradeTransmitted;
	
	@Field("originatingbin") 
	public String originatingBIN;

	@Field("priceprotected")
	public boolean priceProtected;
	
	@Field("redemptionfeeindicator")
	public String redemptionFeeIndicator;
	
	@Field("roaloivalue")
	public String roaLoiValue;
	
	@Field("saleschargerate")
	public double salesChargeRate;
	
	@Field("shorttermredemptionfeemoneyamount")
	public double shortTermRedemptionFeeMoneyAmount;
	
	@Field("shorttermredemptionfeerate") 
	public double shortTermRedemptionFeeRate;

	@Field("shorttermredemptionfeeshareamount")
	public double shortTermRedemptionFeeShareAmount;
	
	@Field("shorttermredemptionfeewaiverreasoncode")
	public String shortTermRedemptionFeeWaiverReasonCode;
	
	@Field("socialcode")
	public String socialCode;
	
	@Field("transactionreceiveddate")
	public String transactionReceivedDate;//should be date
	
	@Field("transactionreceivedtime") 
	public String transactionReceivedTime;//Should be time

	@Field("underwritercommissionamount")
	public double underwriterCommissionAmount;
	
	@Field("worked")
	public boolean worked;
}
