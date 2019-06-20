package com.dst.subaccounting.postgre.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {

	private int commentId;
	private String commentText;
	private Date commentDateTime; // Should be date
	private String commentUserId;

	public Comment(int commentId, String commentText, Date commentDateTime, String commentUserId) {
		this.commentId = commentId;
		this.commentText = commentText;
		this.commentDateTime = commentDateTime;
		this.commentUserId = commentUserId;
	}
}
