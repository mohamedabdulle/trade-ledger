/*
 * COPYRIGHT:
 *
 *   The computer systems, procedures, data bases and programs
 *   created and maintained by DST Systems, Inc., are proprietary
 *   in nature and as such are confidential.  Any unauthorized
 *   use or disclosure of such information may result in civil
 *   liabilities.
 *
 *   Copyright 2019 by DST Systems, Inc.
 *   All Rights Reserved.
 */
package com.dst.subaccounting.postgre.model;

import com.dst.subaccounting.postgre.PostgreRow;

import lombok.Data;

@Data
public class PostgreTransactionDialog implements PostgreRow {
   
	public static String getTableName() {
		return "TransactionDialog";
	}
	
	private Integer transactionDialogId;
    private String transmissionReceivedDateTime;
    private String transmissionId1;
    private String transmissionId2;
    private String transmissionTransactionId;
    private String dialogSeqNumber;
    private String dialogDirection;
    private String nsccRecordType;
    private String transmissionRecordType;
    private String unformattedRecordType;
    private double shareQuantity;
    private double grossMoneyAmount;
    private double netMoneyAmount;
    private double price;
    private double exchangeToShareQuantity;
    private double exchangeToGrossMoneyAmount;
    private double exchangeToNetMoneyAmount;
    private double exchangeToPrice;
    
    private Integer clientTransactionId;
    
    @Override
    public String toString() {
	return "TransactionDialog [transmissionReceivedDateTime=" + transmissionReceivedDateTime + ", transmissionId1="
		+ transmissionId1 + ", transmissionId2=" + transmissionId2 + ", transmissionTransactionId="
		+ transmissionTransactionId + ", dialogSeqNumber=" + dialogSeqNumber + ", dialogDirection="
		+ dialogDirection + ", nsccRecordType=" + nsccRecordType + ", transmissionRecordType="
		+ transmissionRecordType + ", unformattedRecordType=" + unformattedRecordType + ", shareQuantity="
		+ shareQuantity + ", grossMoneyAmount=" + grossMoneyAmount + ", netMoneyAmount=" + netMoneyAmount
		+ ", price=" + price + ", exchangeToShareQuantity=" + exchangeToShareQuantity
		+ ", exchangeToGrossMoneyAmount=" + exchangeToGrossMoneyAmount + ", exchangeToNetMoneyAmount="
		+ exchangeToNetMoneyAmount + ", echangeToPrice=" + exchangeToPrice + "]";
    }

    public PostgreTransactionDialog() {}
    
	public PostgreTransactionDialog(TransactionDialog td, Integer ctId) {
		setTransmissionReceivedDateTime(td.getTransmissionReceivedDateTime());
	    setTransmissionId1(td.getTransmissionId1());
	    setTransmissionId2(td.getTransmissionId2());
	    setTransmissionTransactionId(td.getTransmissionTransactionId());
	    setDialogSeqNumber(td.getDialogSeqNumber());
	    setDialogDirection(td.getDialogDirection());
	    setNsccRecordType(td.getNsccRecordType());
	    setTransmissionRecordType(td.getTransmissionRecordType());
	    setUnformattedRecordType(td.getUnformattedRecordType());
	    setShareQuantity(td.getShareQuantity());
	    setGrossMoneyAmount(td.getGrossMoneyAmount());
	    setNetMoneyAmount(td.getNetMoneyAmount());
	    setPrice(td.getPrice());
	    setExchangeToShareQuantity(td.getExchangeToShareQuantity());
	    setExchangeToGrossMoneyAmount(td.getExchangeToGrossMoneyAmount());
	    setExchangeToNetMoneyAmount(td.getExchangeToNetMoneyAmount());
	    setExchangeToPrice(td.getExchangeToPrice());
	    
	    setClientTransactionId(ctId);	
	}
    
    
}

