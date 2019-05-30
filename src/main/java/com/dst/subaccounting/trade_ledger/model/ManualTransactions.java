package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class ManualTransactions {
	@Field("529liquidationindicator")
	private String liquidationIndicator529;
	
	@Field("accrualearningsstartstopdate")
	private String accrualEarningsStartStopDate;//Should be date
	
	@Field("actualroavalue") 
	private String actualRoaValue;

	@Field("actualroavaluesource")
	private String actualRoaValueSource;
	
	@Field("advancedcommissionamount")
	private String advancedCommissionAmount;

	@Field("aggregated")
	private boolean aggregated;
	
	@Field("allsharetransaction")
	private boolean allShareTransaction;
	
	@Field("anticipatedsettlementdate") 
	private String anticipatedSettlementDate;

	@Field("asofpaymentdate")
	private String asofPaymentDate;//Should be date
	
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
	private double contingentDeferredSalesChargeMoneyAmount;

	@Field("cumulativediscountnumber")
	private String cumulativeDiscountNumber;
	
	@Field("discountcategory")
	private String discountCategory;
	
	@Field("eventid") 
	private String eventId;

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
	
	@Field("manualtradeacceptancestatus") 
	private String manualTradeAcceptanceStatus;

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
	
	@Field("omnibustradetransmitted")
	private boolean omnibusTradeTransmitted;

	@Field("redemptionfeeindicator")
	private String redemptionFeeIndicator;
	
	@Field("roaloivalue")
	private String roaLoiValue;
	
	@Field("saleschargerate") 
	private double salesChargeRate;

	@Field("sendeaprecordtobrokersystem")
	private String sendEapRecordToBrokerSystem;
	
	@Field("sendshareholdertradebrokernotification")
	private String sendShareholderTradeBrokerNotification;
	
	@Field("shorttermredemptionfeemoneyamount")
	private double shortTermRedemptionFeeMoneyAmount;

	@Field("shorttermredemptionfeerate")
	private double shortTermRedemptionFeeRate;
	
	@Field("shorttermredemptionfeeshareamount")
	private double shortTermRedemptionFeeShareAmount;
	
	@Field("shorttermredemptionfeewaiverreasoncode") 
	private String shortTermRedemptionFeeWaiverReasonCode;

	@Field("transactionreceiveddate")
	private String transactionReceivedDate;//Should be date
	
	@Field("transactionreceivedtime")
	private String transactionReceivedTime;//Should be Time
	
	@Field("underwritercommissionamount")
	private double underwriterCommissionAmount;
}
