package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.DAO;
import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CommentDAOImpl implements DAO<Comment> {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static String TABLE_NAME = "Comment";
    private static String INSERT_STATEMENT = "INSERT INTO " + TABLE_NAME + "(commentText, commentDateTime, commentUserId) values(:commentId, :commentText, :commentDateTime, :commentUserId)";
    private static String DELETE_STATEMENT = "DELETE FROM " + TABLE_NAME + " WHERE commentId = :commentId";
    
    @Override
    public void insert(Comment comment) {
    	SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(comment);
    	jdbcTemplate.update(INSERT_STATEMENT, namedParameters);
    }
    
    public void bulkInsert(List<Comment> comments) {
    	this.jdbcTemplate.batchUpdate(INSERT_STATEMENT, SqlParameterSourceUtils.createBatch(comments));
    }
    
    public void delete(int commentId) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("commentId", commentId);
    	jdbcTemplate.update(DELETE_STATEMENT, map);
    }
    
    public void bulkDelete(String[] commentIds) {
    	
    }
    
    @Override
    public List<Comment> getAll() {
        return jdbcTemplate.query("select * from " + TABLE_NAME, new CommentMapper());
    }
}
