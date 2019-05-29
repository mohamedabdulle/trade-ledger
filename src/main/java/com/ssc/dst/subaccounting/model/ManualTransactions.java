package com.ssc.dst.subaccounting.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class ManualTransactions {
	@Field("529liquidationindicator")
	public String liquidationIndicator529;
	
	@Field("accrualearningsstartstopdate")
	public String accrualEarningsStartStopDate;//Should be date
	
	@Field("actualroavalue") 
	public String actualRoaValue;

	@Field("actualroavaluesource")
	public String actualRoaValueSource;
	
	@Field("advancedcommissionamount")
	public String advancedCommissionAmount;

	@Field("aggregated")
	public boolean aggregated;
	
	@Field("allsharetransaction")
	public boolean allShareTransaction;
	
	@Field("anticipatedsettlementdate") 
	public String anticipatedSettlementDate;

	@Field("asofpaymentdate")
	public String asofPaymentDate;//Should be date
	
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
	public double contingentDeferredSalesChargeMoneyAmount;

	@Field("cumulativediscountnumber")
	public String cumulativeDiscountNumber;
	
	@Field("discountcategory")
	public String discountCategory;
	
	@Field("eventid") 
	public String eventId;

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
	
	@Field("manualtradeacceptancestatus") 
	public String manualTradeAcceptanceStatus;

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
	
	@Field("omnibustradetransmitted")
	public boolean omnibusTradeTransmitted;

	@Field("redemptionfeeindicator")
	public String redemptionFeeIndicator;
	
	@Field("roaloivalue")
	public String roaLoiValue;
	
	@Field("saleschargerate") 
	public double salesChargeRate;

	@Field("sendeaprecordtobrokersystem")
	public String sendEapRecordToBrokerSystem;
	
	@Field("sendshareholdertradebrokernotification")
	public String sendShareholderTradeBrokerNotification;
	
	@Field("shorttermredemptionfeemoneyamount")
	public double shortTermRedemptionFeeMoneyAmount;

	@Field("shorttermredemptionfeerate")
	public double shortTermRedemptionFeeRate;
	
	@Field("shorttermredemptionfeeshareamount")
	public double shortTermRedemptionFeeShareAmount;
	
	@Field("shorttermredemptionfeewaiverreasoncode") 
	public String shortTermRedemptionFeeWaiverReasonCode;

	@Field("transactionreceiveddate")
	public String transactionReceivedDate;//Should be date
	
	@Field("transactionreceivedtime")
	public String transactionReceivedTime;//Should be Time
	
	@Field("underwritercommissionamount")
	public double underwriterCommissionAmount;
}
