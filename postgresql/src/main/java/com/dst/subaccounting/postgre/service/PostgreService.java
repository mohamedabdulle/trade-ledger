package com.dst.subaccounting.postgre.service;

import com.dst.subaccounting.postgre.dao.ClientTransactionDAOImpl;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostgreService {
    
    @Autowired
	private ClientTransactionDAOImpl clientTransactionDAO;

    /*
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
*/
    public List<ClientTransaction> getAllClientTransactions() {
        return clientTransactionDAO.getAll();
     }
     
     public void insertClientTransaction(ClientTransaction clientTransaction) {
     	clientTransactionDAO.insert(clientTransaction);
     }
     
     public void insertManyClientTransactions(List<ClientTransaction> clientTransactions) {
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

     public List<ClientTransaction> getClientTransactionsToProcess(){
         return clientTransactionDAO.getTransactionToProcess();
     }
}
