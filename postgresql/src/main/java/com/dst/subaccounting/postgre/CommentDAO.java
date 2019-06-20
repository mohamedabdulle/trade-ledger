package com.dst.subaccounting.postgre;

import com.dst.subaccounting.postgre.model.Comment;

import java.util.List;

public interface CommentDAO {
    void insert(Comment comment);
    List<Comment> getAllComments();

}
