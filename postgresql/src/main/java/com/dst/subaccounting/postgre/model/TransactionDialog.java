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

public class TransactionDialog {
    
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
    
    
    public String getTransmissionReceivedDateTime() {
        return transmissionReceivedDateTime;
    }
    public void setTransmissionReceivedDateTime(String transmissionReceivedDateTime) {
        this.transmissionReceivedDateTime = transmissionReceivedDateTime;
    }
    public String getTransmissionId1() {
        return transmissionId1;
    }
    public void setTransmissionId1(String transmissionId1) {
        this.transmissionId1 = transmissionId1;
    }
    public String getTransmissionId2() {
        return transmissionId2;
    }
    public void setTransmissionId2(String transmissionId2) {
        this.transmissionId2 = transmissionId2;
    }
    public String getTransmissionTransactionId() {
        return transmissionTransactionId;
    }
    public void setTransmissionTransactionId(String transmissionTransactionId) {
        this.transmissionTransactionId = transmissionTransactionId;
    }
    public String getDialogSeqNumber() {
        return dialogSeqNumber;
    }
    public void setDialogSeqNumber(String dialogSeqNumber) {
        this.dialogSeqNumber = dialogSeqNumber;
    }
    public String getDialogDirection() {
        return dialogDirection;
    }
    public void setDialogDirection(String dialogDirection) {
        this.dialogDirection = dialogDirection;
    }
    public String getNsccRecordType() {
        return nsccRecordType;
    }
    public void setNsccRecordType(String nsccRecordType) {
        this.nsccRecordType = nsccRecordType;
    }
    public String getTransmissionRecordType() {
        return transmissionRecordType;
    }
    public void setTransmissionRecordType(String transmissionRecordType) {
        this.transmissionRecordType = transmissionRecordType;
    }
    public String getUnformattedRecordType() {
        return unformattedRecordType;
    }
    public void setUnformattedRecordType(String unformattedRecordType) {
        this.unformattedRecordType = unformattedRecordType;
    }
    public double getShareQuantity() {
        return shareQuantity;
    }
    public void setShareQuantity(double shareQuantity) {
        this.shareQuantity = shareQuantity;
    }
    public double getGrossMoneyAmount() {
        return grossMoneyAmount;
    }
    public void setGrossMoneyAmount(double grossMoneyAmount) {
        this.grossMoneyAmount = grossMoneyAmount;
    }
    public double getNetMoneyAmount() {
        return netMoneyAmount;
    }
    public void setNetMoneyAmount(double netMoneyAmount) {
        this.netMoneyAmount = netMoneyAmount;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getExchangeToShareQuantity() {
        return exchangeToShareQuantity;
    }
    public void setExchangeToShareQuantity(double exchangeToShareQuantity) {
        this.exchangeToShareQuantity = exchangeToShareQuantity;
    }
    public double getExchangeToGrossMoneyAmount() {
        return exchangeToGrossMoneyAmount;
    }
    public void setExchangeToGrossMoneyAmount(double exchangeToGrossMoneyAmount) {
        this.exchangeToGrossMoneyAmount = exchangeToGrossMoneyAmount;
    }
    public double getExchangeToNetMoneyAmount() {
        return exchangeToNetMoneyAmount;
    }
    public void setExchangeToNetMoneyAmount(double exchangeToNetMoneyAmount) {
        this.exchangeToNetMoneyAmount = exchangeToNetMoneyAmount;
    }
    public double getExchangeToPrice() {
        return exchangeToPrice;
    }
    public void setExchangeToPrice(double exchangeToPrice) {
        this.exchangeToPrice = exchangeToPrice;
    }
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
    
    
}

