package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clientTransactions")
public class ShortTermTraderLots {
	
	@Field("crossshareclassexchange")
	private boolean crossShareClassExchange;

	@Field("frombin")
	private String fromBin;

	@Field("fromfund_id")
	private String fromFund_id;

	@Field("lotid")
	private String lotId;

	@Field("lottype")
	private String lotType;

	@Field("releasedate")
	private String releaseDate; // Should be date

	@Field("shareamount")
	private double shareAmount;

	@Field("shareeligibleforfee")
	private double shareEligibleForFee;

	@Field("updatedintraday")
	private String updatedIntraday;

	@Field("waiveramount")
	private double waiverAmount;

	@Field("waiverrate")
	private double waiverRate;

	@Field("waiverreasoncode")
	private String waiverReasonCode;
}
