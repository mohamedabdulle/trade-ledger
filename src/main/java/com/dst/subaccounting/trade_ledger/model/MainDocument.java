package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class MainDocument {

	@Id
	private String id;
	
	@Field("actualpostingdate")
	private String actualPostingDate;
	
	@Field("agentforfirm")
	private String agentForFirm;
	
	@Field("anticipatedpostingdate")
	private String anticipatedPostingDate;
	
	@Field("bin")
	private String bin;
	
	@Field("clearingfirmnumber")
	private int clearingFirmNumber;
	
	@Field("countrycode")
	private String countryCode;
}
