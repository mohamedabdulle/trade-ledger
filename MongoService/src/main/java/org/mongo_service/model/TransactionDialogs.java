package org.mongo_service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clientTransactions")
public class TransactionDialogs {
	
	@Field("anticipatedsettlementdate")
	private String anticipatedSettlementDate; // Should be date

	@Field("contingentdeferredsaleschargemoneyamount")
	private double contingentDeferredSalesChargeMoneyAmount;

	@Field("createddatetime")
	private String createdDateTime;

	@Field("dialogdirection")
	private String dialogDirection;

	@Field("exchangetogrossmoneyamount")
	private double exchangeToGrossMoneyAmount;

	@Field("exchangetonetmoneyamount")
	private double exchangeToNetMoneyAmount;

	@Field("exchangetoprice")
	private double exchangeToPrice;

	@Field("exchangetosharequantity")
	private String exchangeToShareQuantity;

	@Field("firmcommissionamount")
	private double firmCommissionAmount;

	@Field("grossmoneyamount")
	private double grossMoneyAmount;

	@Field("netmoneyamount")
	private double netMoneyAmount;

	@Field("nsccrecordtype")
	private String nsccRecordType;

	@Field("price")
	private double price;

	@Field("redemptionfeeindicator")
	private String redemptionFeeIndicator;

	@Field("redemptionfeemoneyamount")
	private double redemptionFeeMoneyAmount;

	@Field("redemptionfeerate")
	private double redemptionFeeRate;

	@Field("saleschargerate")
	private double salesChargeRate;

	@Field("sharequantity")
	private String shareQuantity;

	@Field("shorttermredemptionfeesharequantity")
	private String shortTermRedemptionFeeShareQuantity;

	@Field("transmissionid1")
	private String transmissionId1;

	@Field("transmissionid2")
	private String transmissionId2;

	@Field("transmissionreceiveddatetime")
	private String transmissionReceivedDateTime;

	@Field("transmissionrecordtype")
	private String transmissionRecordType;

	@Field("transmissiontransactionid")
	private String transmissionTransactionId;

	// I dont know whether we need to put these into their seperate class
	// Rejectinfo
	@Field("internalrejectcode")
	private String internalRejectCode;

	@Field("nsccrejectcode")
	private String nsccRejectCode;

	@Field("rejectdescription")
	private String rejectDescription;

	@Field("rejectid")
	private String rejectId;

	// UnformattedData
	@Field("dialogsequencenumber")
	private String dialogSequenceNumber;

	@Field("unformattedrecordtext")
	private String unformattedRecordText;
}
