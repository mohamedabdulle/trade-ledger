package com.dst.subaccounting.trade_ledger.model.setup;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Comments {
	
	@Field("comment")
	@JsonAlias("comment")
	private String comment;

	@Field("commentdatetime")
	@JsonAlias("commentdatetime")
	private String commentDateTime; // Should be date

	@Field("commentuserid")
	@JsonAlias("commentuserid")
	private String commentUserId;
}
