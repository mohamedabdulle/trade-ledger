package com.dst.subaccounting.postgre.service;

import com.dst.subaccounting.postgre.dao.CommentDAOImpl;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostgreService {

    @Autowired
    CommentDAOImpl commentDAO;

    public List<Comment> getAll() {
       return commentDAO.getAllComments();
    }
    
    public void insert(Comment comment) {
    	commentDAO.insert(comment);
    }
    
    public void insertComment(Comment comment) {
    	//TO DO: rename regular insert to this
    }
    
    public void insertManyComment(ArrayList<Comment> commentList) {
    	//TO DO
    }
    
    public void deleteManyComment() {
    	// TO DO
    }
}
