package com.ssc.dst.subaccounting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class MainDocument {

	@Id
	private String id;
	private String actualPostingDate;
	private String agentForFirm;
}
