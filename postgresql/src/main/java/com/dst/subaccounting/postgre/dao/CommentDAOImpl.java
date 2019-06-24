package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.CommentDAO;
import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static String TABLE_NAME = "Comment";
    private static String INSERT_STATEMENT = "insert into " + TABLE_NAME + "(commentId, commentText, commentDateTime, commentUserId) values(?,?,?,?)";
    
    @Override
    public void insert(Comment comment) {
    	jdbcTemplate.update(INSERT_STATEMENT, comment.getCommentId(), comment.getCommentText(), comment.getCommentDateTime(), comment.getCommentUserId());
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query("select * from Comment", new CommentMapper());
    }
}
