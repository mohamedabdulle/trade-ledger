package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class TransactionDialogs {
	@Field("anticipatedsettlementdate")
	public String anticipatedSettlementDate;//Should be date
	
	@Field("contingentdeferredsaleschargemoneyamount") 
	public double contingentDeferredSalesChargeMoneyAmount;

	@Field("createddatetime")
	public String createdDateTime;
	
	@Field("dialogdirection")
	public String dialogDirection;
	
	@Field("exchangetogrossmoneyamount")
	public double exchangeToGrossMoneyAmount;

	@Field("exchangetonetmoneyamount")
	public double exchangeToNetMoneyAmount;
	
	@Field("exchangetoprice") 
	public double exchangeToPrice;

	@Field("exchangetosharequantity")
	public String exchangeToShareQuantity;
	
	@Field("firmcommissionamount")
	public double firmCommissionAmount;
	
	@Field("grossmoneyamount")
	public double grossMoneyAmount;
	
	@Field("netmoneyamount")
	public double netMoneyAmount;
	
	@Field("nsccrecordtype")
	public String nsccRecordType;
	
	@Field("price")
	public double price;
	
	@Field("redemptionfeeindicator") 
	public String redemptionFeeIndicator;

	@Field("redemptionfeemoneyamount")
	public double redemptionFeeMoneyAmount;
	
	@Field("redemptionfeerate")
	public double redemptionFeeRate;
	
	@Field("saleschargerate")
	public double salesChargeRate;

	@Field("sharequantity")
	public String shareQuantity;
	
	@Field("shorttermredemptionfeesharequantity") 
	public String shortTermRedemptionFeeShareQuantity;

	@Field("transmissionid1")
	public String transmissionId1;
	
	@Field("transmissionid2")
	public String transmissionId2;
	
	@Field("transmissionreceiveddatetime")
	public String transmissionReceivedDateTime;
	
	@Field("transmissionrecordtype")
	public String transmissionRecordType;
	
	@Field("transmissiontransactionid")
	public String transmissionTransactionId;
	
	//I dont know whether we need to put these into their seperate class
	//Rejectinfo
	@Field("internalrejectcode") 
	public String internalRejectCode;

	@Field("nsccrejectcode")
	public String nsccRejectCode;
	
	@Field("rejectdescription")
	public String rejectDescription;
	
	@Field("rejectid")
	public String rejectId;
	
	//UnformattedData
	@Field("dialogsequencenumber")
	public String dialogSequenceNumber;
	
	@Field("unformattedrecordtext")
	public String unformattedRecordText;
}
