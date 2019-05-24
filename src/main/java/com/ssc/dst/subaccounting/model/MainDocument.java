package com.ssc.dst.subaccounting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class MainDocument {

	@Id
	private String id;
	
	@Field("actualPostingDate")
	private String actualPostingDate;
	
	@Field("agentForFirm")
	private String agentForFirm;
	
	@Field("anticipatedPostingDate")
	private String anticipatedPostingDate;
	
	@Field("bin")
	private String bin;
	
	@Field("clearingFirmNumber")
	private int clearingFirmNumber;
	
	@Field("countryCode")
	private String countryCode;
}
