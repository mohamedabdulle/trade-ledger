package com.dst.subaccounting.postgre.dao;

import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;

@Repository
public class CommentDAOImpl extends GenericDAOImpl<Comment> {
	
	public CommentDAOImpl() {
		super("id", "Comment", new Comment().getClass(), new CommentMapper());
	}
	
}
