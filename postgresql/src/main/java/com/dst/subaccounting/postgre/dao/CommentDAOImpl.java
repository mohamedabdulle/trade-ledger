package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.CommentDAO;
import com.dst.subaccounting.postgre.config.AppConfig;
import com.dst.subaccounting.postgre.mapper.CommentMapper;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    JdbcTemplate postgreSQLJdbcTemplate;

    @Override
    public void insert(Comment comment) {
    }

    @Override
    public List<Comment> getAllComments() {
        return postgreSQLJdbcTemplate.query("select * from Comment", new CommentMapper());
    }
}
