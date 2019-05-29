package com.ssc.dst.subaccounting.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class Comments {
	@Field("comment")
	public String comment;
	
	@Field("commentdatetime")
	public String commentDateTime; //Should be date
	
	@Field("commentuserid")
	public String commentUserId;
}
