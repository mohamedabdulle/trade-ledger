package com.dst.subaccounting.postgre.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.reflect.*;

import org.springframework.stereotype.Repository;

import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;

@Repository
public class CommentDAOImpl extends GenericDAOImpl<Comment> {
	
	public CommentDAOImpl() {
		super("commentId", "Comment", new Comment().getClass(), new CommentMapper());
	}
	
}
