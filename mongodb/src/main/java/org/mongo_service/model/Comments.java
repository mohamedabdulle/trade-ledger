package org.mongo_service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clientTransactions")
public class Comments {
	
	@Field("comment")
	private String comment;

	@Field("commentdatetime")
	private String commentDateTime; // Should be date

	@Field("commentuserid")
	private String commentUserId;
}
