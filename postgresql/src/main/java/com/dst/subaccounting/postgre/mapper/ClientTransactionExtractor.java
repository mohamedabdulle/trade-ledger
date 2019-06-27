package com.dst.subaccounting.postgre.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.dst.subaccounting.postgre.model.ClientTransaction;
import com.dst.subaccounting.postgre.model.RejectDialog;
import com.dst.subaccounting.postgre.model.TransactionDialog;

public final class ClientTransactionExtractor implements ResultSetExtractor<List<ClientTransaction>> {

	@Override
	public List<ClientTransaction> extractData(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		for(int i = 1; i <= rsmd.getColumnCount(); ++i) {
			System.out.println(rsmd.getColumnName(i));
		}

		Map<Integer, ClientTransaction> ctMap = new HashMap<>();

		while (rs.next()) {
			Integer ctId = rs.getInt("clientTransactionId");

			ClientTransaction ctDoc = ctMap.get(ctId);

			// initialize new doc if it doesn't exist
			if (ctDoc == null) {
				ctDoc = makeClientTransaction(rs);
				ctMap.put(ctId, ctDoc);
			}

			// add dialogs to existing client Transaction doc
			ctDoc.getTransactionDialogs().add(makeTransactionDialog(rs));
			ctDoc.getRejectDialogs().add(makeRejectDialog(rs));
		}

		return ctMap.values().stream().collect(Collectors.toList());
	}

	// TO DO
	private ClientTransaction makeClientTransaction(ResultSet rs) throws SQLException {
		ClientTransaction ct = new ClientTransaction();
		Integer id = rs.getInt("clientTransactionId");
		ct.setClientTransactionId(id);

		int clearingFirmNumber = rs.getInt("clearingFirmNumber");
		ct.setClearingFirmNumber(clearingFirmNumber);
		int dealerFirmNumber = rs.getInt("dealerFirmNumber");
		ct.setDealerFirmNumber(dealerFirmNumber);
		String agentForFirm = rs.getString("agentForFirm");
		ct.setAgentForFirm(agentForFirm);
		String bin = rs.getString("bin");
		ct.setBin(bin);
		String fundId = rs.getString("fundId"); // Reference to _id field within security master
		ct.setFundId(fundId);
		String cusip = rs.getString("cusip");
		ct.setCusip(cusip);
		String exchangetoCusip = rs.getString("exchangetoCusip");
		ct.setExchangetoCusip(exchangetoCusip);
		String nsccControlNumber = rs.getString("nsccControlNumber");
		ct.setNsccControlNumber(nsccControlNumber);
		String nsccCorrectionIndicator = rs.getString("nsccCorrectionIndicator");
		ct.setNsccCorrectionIndicator(nsccCorrectionIndicator);
		String currencyIndicator = rs.getString("currencyIndicator");
		ct.setCurrencyIndicator(currencyIndicator);
		double price = rs.getDouble("price");
		ct.setPrice(price);
		String distributionEventType = rs.getString("distributionEventType");
		ct.setDistributionEventType(distributionEventType);
		String distributionRecordDate = rs.getString("distributionRecordDate");
		ct.setDistributionRecordDate(distributionRecordDate);
		String tradeDate = rs.getString("tradeDate"); // Would be date field
		ct.setTradeDate(tradeDate);
		String submissionDate = rs.getString("submissionDate");
		ct.setSubmissionDate(submissionDate);
		String transactionRecievedDate = rs.getString("transactionRecievedDate");
		ct.setTransactionRecievedDate(transactionRecievedDate);
		String transactionRecievedTime = rs.getString("transactionRecievedTime");
		ct.setTransactionRecievedTime(transactionRecievedTime);
		String anticipatedSettlementDate = rs.getString("anticipatedSettlementDate");
		ct.setAnticipatedSettlementDate(anticipatedSettlementDate);
		String nsccSettlementOverrideReasonCode = rs.getString("nsccSettlementOverrideReasonCode");
		ct.setNsccSettlementOverrideReasonCode(nsccSettlementOverrideReasonCode);
		String transactionStatus = rs.getString("transactionStatus");
		ct.setTransactionStatus(transactionStatus);
		String workedCd = rs.getString("workedCd");
		ct.setWorkedCd(workedCd);
		String priceProtected = rs.getString("priceProtected");
		ct.setPriceProtected(priceProtected);
		String contingentDeferredSalesChargeLiquidationIndicator = rs
				.getString("contingentDeferredSalesChargeLiquidationIndicator");
		ct.setContingentDeferredSalesChargeLiquidationIndicator(contingentDeferredSalesChargeLiquidationIndicator);
		String liquidationIndicator529 = rs.getString("liquidationIndicator529");
		ct.setLiquidationIndicator529(liquidationIndicator529);
		String navReasonCode = rs.getString("navReasonCode");
		ct.setNavReasonCode(navReasonCode);
		double salesChargeRate = rs.getDouble("salesChargeRate");
		ct.setSalesChargeRate(salesChargeRate);
		String discountCategory = rs.getString("discountCategory");
		ct.setDiscountCategory(discountCategory);
		String nsccRoaLoiValue = rs.getString("nsccRoaLoiValue");
		ct.setNsccRoaLoiValue(nsccRoaLoiValue);
		String actualRoaValueSource = rs.getString("actualRoaValueSource");
		ct.setActualRoaValueSource(actualRoaValueSource);
		String loiNumber = rs.getString("loiNumber");
		ct.setLoiNumber(loiNumber);
		double shortTermRedemptionFeeRate = rs.getDouble("shortTermRedemptionFeeRate");
		ct.setShortTermRedemptionFeeRate(shortTermRedemptionFeeRate);
		double shortTermRedemptionFeeShareAmount = rs.getDouble("shortTermRedemptionFeeShareAmount");
		ct.setShortTermRedemptionFeeShareAmount(shortTermRedemptionFeeShareAmount);
		double shortTermRedemptionFeeMoneyAmount = rs.getDouble("shortTermRedemptionFeeMoneyAmount");
		ct.setShortTermRedemptionFeeMoneyAmount(shortTermRedemptionFeeMoneyAmount);
		double contingentDeferredSalesChargeMoneyAmount = rs.getDouble("contingentDeferredSalesChargeMoneyAmount");
		ct.setContingentDeferredSalesChargeMoneyAmount(contingentDeferredSalesChargeMoneyAmount);
		double moneyMarketLiquidityFeeRate = rs.getDouble("moneyMarketLiquidityFeeRate");
		ct.setMoneyMarketLiquidityFeeRate(moneyMarketLiquidityFeeRate);
		double moneyMarketLiquidtyFeeMoneyAmount = rs.getDouble("moneyMarketLiquidtyFeeMoneyAmount");
		ct.setMoneyMarketLiquidtyFeeMoneyAmount(moneyMarketLiquidtyFeeMoneyAmount);
		String taxIdNumber = rs.getString("taxIdNumber");
		ct.setTaxIdNumber(taxIdNumber);
		String taxIdType = rs.getString("taxIdType");
		ct.setTaxIdType(taxIdType);
		String branch = rs.getString("branch");
		ct.setBranch(branch);
		String representativeName = rs.getString("representativeName");
		ct.setRepresentativeName(representativeName);
		int representativeNumber = rs.getInt("representativeNumber");
		ct.setRepresentativeNumber(representativeNumber);
		String stateOfSale = rs.getString("stateOfSale");
		ct.setStateOfSale(stateOfSale);
		String countryCode = rs.getString("countryCode");
		ct.setCountryCode(countryCode);
		String socialCode = rs.getString("socialCode");
		ct.setSocialCode(socialCode);
		String moneyMarketLiquidityFeeRedemptionGateIndicator = rs
				.getString("moneyMarketLiquidityFeeRedemptionGateIndicator");
		ct.setMoneyMarketLiquidityFeeRedemptionGateIndicator(moneyMarketLiquidityFeeRedemptionGateIndicator);
		String moneyMarketAggregatedOrderIndicator = rs.getString("moneyMarketAggregatedOrderIndicator");
		ct.setMoneyMarketAggregatedOrderIndicator(moneyMarketAggregatedOrderIndicator);
		String derivedBusinessProcessingGroup = rs.getString("derivedBusinessProcessingGroup");
		ct.setDerivedBusinessProcessingGroup(derivedBusinessProcessingGroup);
		String nsccTransactionType = rs.getString("nsccTransactionType");
		ct.setNsccTransactionType(nsccTransactionType);
		String nsccTransactionCode = rs.getString("nsccTransactionCode");
		ct.setNsccTransactionCode(nsccTransactionCode);
		String nsccOriginalControlNumber = rs.getString("nsccOriginalControlNumber");
		ct.setNsccOriginalControlNumber(nsccOriginalControlNumber);
		String nsccOriginalCorrectionIndicator = rs.getString("nsccOriginalCorrectionIndicator");
		ct.setNsccOriginalCorrectionIndicator(nsccOriginalCorrectionIndicator);
		String nsccTestIndicator = rs.getString("nsccTestIndicator");
		ct.setNsccTestIndicator(nsccTestIndicator);
		String nsccAsofIndicator = rs.getString("nsccAsofIndicator");
		ct.setNsccAsofIndicator(nsccAsofIndicator);
		String asofReasonCode = rs.getString("asofReasonCode");
		ct.setAsofReasonCode(asofReasonCode);
		String nsccCustomerName = rs.getString("nsccCustomerName");
		ct.setNsccCustomerName(nsccCustomerName);
		String nsccFundAccountIndicator = rs.getString("nsccFundAccountIndicator");
		ct.setNsccFundAccountIndicator(nsccFundAccountIndicator);
		String nsccBookPhysicalShareIndicator = rs.getString("nsccBookPhysicalShareIndicator");
		ct.setNsccBookPhysicalShareIndicator(nsccBookPhysicalShareIndicator);
		String nsccRelatedTradeIndicator = rs.getString("nsccRelatedTradeIndicator");
		ct.setNsccRelatedTradeIndicator(nsccRelatedTradeIndicator);
		String assetTypeIndicator = rs.getString("assetTypeIndicator");
		ct.setAssetTypeIndicator(assetTypeIndicator);
		String nsccFractionIndicator = rs.getString("nsccFractionIndicator");
		ct.setNsccFractionIndicator(nsccFractionIndicator);
		String grossNetSettlementIndicator = rs.getString("grossNetSettlementIndicator");
		ct.setGrossNetSettlementIndicator(grossNetSettlementIndicator);
		String nsccSecurityIssueType = rs.getString("nsccSecurityIssueType");
		ct.setNsccSecurityIssueType(nsccSecurityIssueType);
		String nsccFundParticipantNumberCd = rs.getString("nsccFundParticipantNumberCd");
		ct.setNsccFundParticipantNumberCd(nsccFundParticipantNumberCd);
		String nsccOmnibusAccountIndicatorCd = rs.getString("nsccOmnibusAccountIndicatorCd");
		ct.setNsccOmnibusAccountIndicatorCd(nsccOmnibusAccountIndicatorCd);
		String nsccProgramTransactionIndicatorCd = rs.getString("nsccProgramTransactionIndicatorCd");
		ct.setNsccProgramTransactionIndicatorCd(nsccProgramTransactionIndicatorCd);
		String nsccPeriodicFrequencyIndicatorCd = rs.getString("nsccPeriodicFrequencyIndicatorCd");
		ct.setNsccPeriodicFrequencyIndicatorCd(nsccPeriodicFrequencyIndicatorCd);
		String orderNumber = rs.getString("orderNumber");
		ct.setOrderNumber(orderNumber);
		String nsccAcatsControlNumber = rs.getString("nsccAcatsControlNumber");
		ct.setNsccAcatsControlNumber(nsccAcatsControlNumber);
		String nsccAcatsAssetsSequenceId = rs.getString("nsccAcatsAssetsSequenceId");
		ct.setNsccAcatsAssetsSequenceId(nsccAcatsAssetsSequenceId);
		String firmRoleInTransfer = rs.getString("firmRoleInTransfer");
		ct.setFirmRoleInTransfer(firmRoleInTransfer);
		String originatingFirmNumber = rs.getString("originatingFirmNumber");
		ct.setOriginatingFirmNumber(originatingFirmNumber);
		String originatingAgentForFirm = rs.getString("originatingAgentForFirm");
		ct.setOriginatingAgentForFirm(originatingAgentForFirm);
		String originatingBIN = rs.getString("originatingBIN");
		ct.setOriginatingBIN(originatingBIN);
		String originatingFundAccount = rs.getString("originatingFundAccount");
		ct.setOriginatingFundAccount(originatingFundAccount);
		String originatingAccountOmnibusIndicator = rs.getString("originatingAccountOmnibusIndicator");
		ct.setOriginatingAccountOmnibusIndicator(originatingAccountOmnibusIndicator);
		String destinationBIN = rs.getString("destinationBIN");
		ct.setDestinationBIN(destinationBIN);
		String destinationFundAccount = rs.getString("destinationFundAccount");
		ct.setDestinationFundAccount(destinationFundAccount);
		String destinationAccountOmnibusIndicator = rs.getString("destinationAccountOmnibusIndicator");
		ct.setDestinationAccountOmnibusIndicator(destinationAccountOmnibusIndicator);
		String asofPaymentDate = rs.getString("asofPaymentDate");
		ct.setAsofPaymentDate(asofPaymentDate);
		String nsccRegistrationStatusCode = rs.getString("nsccRegistrationStatusCode");
		ct.setNsccRegistrationStatusCode(nsccRegistrationStatusCode);
		String nsccRequestStatusCode = rs.getString("nsccRequestStatusCode");
		ct.setNsccRequestStatusCode(nsccRequestStatusCode);

		return ct;
	}

	private TransactionDialog makeTransactionDialog(ResultSet rs) throws SQLException {
		TransactionDialog td = new TransactionDialog();
		Integer id = rs.getInt("transactionDialogId");
		td.setTransactionDialogId(id);

		String transmissionReceivedDateTime = rs.getString("transmissionReceivedDateTime");
		td.setTransmissionReceivedDateTime(transmissionReceivedDateTime);
		String transmissionId1 = rs.getString("transmissionId1");
		td.setTransmissionId1(transmissionId1);
		String transmissionId2 = rs.getString("transmissionId2");
		td.setTransmissionId2(transmissionId2);
		String transmissionTransactionId = rs.getString("transmissionTransactionId");
		td.setTransmissionTransactionId(transmissionTransactionId);
		String dialogSeqNumber = rs.getString("dialogSeqNumber");
		td.setDialogSeqNumber(dialogSeqNumber);
		String dialogDirection = rs.getString("dialogDirection");
		td.setDialogDirection(dialogDirection);
		String nsccRecordType = rs.getString("nsccRecordType");
		td.setNsccRecordType(nsccRecordType);
		String transmissionRecordType = rs.getString("transmissionRecordType");
		td.setTransmissionRecordType(transmissionRecordType);
		String unformattedRecordType = rs.getString("unformattedRecordType");
		td.setUnformattedRecordType(unformattedRecordType);
		double shareQuantity = rs.getDouble("shareQuantity");
		td.setShareQuantity(shareQuantity);
		double grossMoneyAmount = rs.getDouble("grossMoneyAmount");
		td.setGrossMoneyAmount(grossMoneyAmount);
		double netMoneyAmount = rs.getDouble("netMoneyAmount");
		td.setNetMoneyAmount(netMoneyAmount);
		double price = rs.getDouble("price");
		td.setPrice(price);
		double exchangeToShareQuantity = rs.getDouble("exchangeToShareQuantity");
		td.setExchangeToShareQuantity(exchangeToShareQuantity);
		double exchangeToGrossMoneyAmount = rs.getDouble("exchangeToGrossMoneyAmount");
		td.setExchangeToGrossMoneyAmount(exchangeToGrossMoneyAmount);
		double exchangeToNetMoneyAmount = rs.getDouble("exchangeToNetMoneyAmount");
		td.setExchangeToNetMoneyAmount(exchangeToNetMoneyAmount);
		double exchangeToPrice = rs.getDouble("exchangeToPrice");
		td.setExchangeToPrice(exchangeToPrice);

		return td;
	}

	// TO DO
	private RejectDialog makeRejectDialog(ResultSet rs) throws SQLException {

		RejectDialog rd = new RejectDialog();

		Integer rejectDialogId = rs.getInt("rejectDialogId");
		rd.setRejectDialogId(rejectDialogId);
		String rejectId = rs.getString("rejectId");
		rd.setRejectId(rejectId);
		String rejectCode = rs.getString("rejectCode");
		rd.setRejectCode(rejectCode);
		String rejectDescription = rs.getString("rejectDescription");
		rd.setRejectDescription(rejectDescription);

		return rd;
	}

}