package com.dst.subaccounting.postgre.mapper;

import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(resultSet.getInt("CommentId"));
        comment.setCommentText(resultSet.getString("CommentText"));
        comment.setCommentDateTime(resultSet.getDate("CommentDateTime"));
        comment.setCommentUserId(resultSet.getString("CommentUserId"));
        return comment;
    }
}
