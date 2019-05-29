package com.ssc.dst.subaccounting.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class ShortTermTraderLots {
	@Field("crossshareclassexchange")
	public boolean crossShareClassExchange;
	
	@Field("frombin") 
	public String fromBin;

	@Field("fromfund_id")
	public String fromFund_id;
	
	@Field("lotid")
	public String lotId;
	
	@Field("lottype")
	public String lotType;

	@Field("releasedate")
	public String releaseDate;//Should be date
	
	@Field("shareamount") 
	public double shareAmount;

	@Field("shareeligibleforfee")
	public double shareEligibleForFee;
	
	@Field("updatedintraday")
	public String updatedIntraday;
	
	@Field("waiveramount")
	public double waiverAmount;
	
	@Field("waiverrate")
	public double waiverRate;
	
	@Field("waiverreasoncode")
	public String waiverReasonCode;
}
