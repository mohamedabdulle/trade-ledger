package com.dst.subaccounting.postgre.service;

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
       return commentDAO.getAll();
    }
    
    public void insertComment(Comment comment) {
    	commentDAO.insert(comment);
    }
    
    public void insertManyComment(List<Comment> comments) {
    	commentDAO.bulkInsert(comments);
    }
    
    public void deleteComment(int commentId) {
    	commentDAO.delete(commentId);
    }
    
    public void deleteManyComment(int[] commentIds) {
    	commentDAO.bulkDelete(commentIds);
    }

    public void deleteAll(){
        commentDAO.deleteAll();
    }

    public List<Comment> getTransactionToProcess(){
        return commentDAO.getTransactionToProcess();
    }
}
