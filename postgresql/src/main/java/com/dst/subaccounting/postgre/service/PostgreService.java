package com.dst.subaccounting.postgre.service;

import com.dst.subaccounting.postgre.CommentDAO;
import com.dst.subaccounting.postgre.dao.CommentDAOImpl;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostgreService {

    @Autowired
    CommentDAOImpl commentDAO;

    public List<Comment> getAll() {
       return commentDAO.getAllComments();
    }
}
