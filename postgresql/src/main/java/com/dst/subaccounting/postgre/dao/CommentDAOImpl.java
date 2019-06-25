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

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static String TABLE_NAME = "Comment";
    private static String INSERT_STATEMENT = "INSERT INTO " + TABLE_NAME + "(commentId, commentText, commentDateTime, commentUserId) values(:commentId, :commentText, :commentDateTime, :commentUserId)";
    private static String DELETE_STATEMENT = "DELETE FROM " + TABLE_NAME + " WHERE " + TABLE_NAME + ".commentId = :commentId";
    private static String DELETE_ALL_STATEMENT = "DELETE FROM " + TABLE_NAME;
    
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
    
    public void bulkDelete(int[] commentIds) {
    	HashMap<String,Integer>[] map = new HashMap[commentIds.length];
    	for(int i = 0; i < commentIds.length;i++){
    	    map[i] = new HashMap<String,Integer>();
    	    map[i].put("commentId", commentIds[i]);
        }
    	jdbcTemplate.batchUpdate(DELETE_STATEMENT,map);
    }

    public void deleteAll(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        jdbcTemplate.update(DELETE_ALL_STATEMENT,map);
    }
    
    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query("select * from Comment", new CommentMapper());
    }
}
