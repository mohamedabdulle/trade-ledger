package com.dst.subaccounting.postgre.service;

import com.dst.subaccounting.postgre.dao.ClientTransactionsDocumentDAOImpl;
import com.dst.subaccounting.postgre.dao.CommentDAOImpl;
import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;
import com.dst.subaccounting.postgre.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostgreService {

    @Autowired
    private CommentDAOImpl commentDAO;
    
    @Autowired
	private ClientTransactionsDocumentDAOImpl clientTransactionDAO;

    public List<Comment> getAllComments() {
       return commentDAO.getAll();
    }
    
    public void insertComment(Comment comment) {
    	commentDAO.insert(comment);
    }
    
    public void insertManyComments(List<Comment> comments) {
    	commentDAO.bulkInsert(comments);
    }
    
    public void deleteComments(int commentId) {
    	commentDAO.delete(commentId);
    }
    
    public void deleteManyComments(int[] commentIds) {
    	commentDAO.bulkDelete(commentIds);
    }

    public void deleteAllComments(){
        commentDAO.deleteAll();
    }

    public List<ClientTransactionsDocument> getAllClientTransactions() {
        return clientTransactionDAO.getAll();
     }
     
     public void insertClientTransaction(ClientTransactionsDocument clientTransaction) {
     	clientTransactionDAO.insert(clientTransaction);
     }
     
     public void insertManyClientTransactions(List<ClientTransactionsDocument> clientTransactions) {
     	clientTransactionDAO.bulkInsert(clientTransactions);
     }
     
     public void deleteClientTransactions(int id) {
     	clientTransactionDAO.delete(id);
     }
     
     public void deleteManyClientTransactions(int[] ids) {
     	clientTransactionDAO.bulkDelete(ids);
     }

     public void deleteAllClientTransactions(){
         clientTransactionDAO.deleteAll();
     }

     public List<ClientTransactionsDocument> getClientTransactionsToProcess(){
         return clientTransactionDAO.getTransactionToProcess();
     }
}
