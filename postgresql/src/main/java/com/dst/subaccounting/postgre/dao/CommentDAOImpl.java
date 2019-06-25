package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.CommentDAO;
import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static String TABLE_NAME = "Comment";
    private static String INSERT_STATEMENT = "insert into " + TABLE_NAME + "(commentId, commentText, commentDateTime, commentUserId) values(:commentId, :commentText, :commentDateTime, :commentUserId)";
    
    @Override
    public void insert(Comment comment) {
    	SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(comment);
    	jdbcTemplate.update(INSERT_STATEMENT, namedParameters);
    }
    
    public void bulkInsert(List<Comment> comments) {
    	this.jdbcTemplate.batchUpdate(INSERT_STATEMENT, SqlParameterSourceUtils.createBatch(comments));
    }
    
    public void bulkDelete() {
    	//TO DO
    }
    
    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query("select * from Comment", new CommentMapper());
    }
}
