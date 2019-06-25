package com.dst.subaccounting.postgre.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {

	private Integer commentId;
	private String commentText;
	private Date commentDateTime; // Should be date
	private String commentUserId;
}
