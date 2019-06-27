package com.dst.subaccounting.postgre.controller;

import com.dst.subaccounting.postgre.model.ClientTransaction;
import com.dst.subaccounting.postgre.model.Comment;
import com.dst.subaccounting.postgre.service.PostgreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/postgre")
public class PostgreController {

    @Autowired
    PostgreService postgreService;

    @GetMapping("/comment")
    public List<Comment> getAllComments() {
        return postgreService.getAllComments();
    }
    
    @PostMapping("/comment")
    public void insertComment(@RequestBody Comment comment) {
    	postgreService.insertComment(comment);
    }
    
    @PostMapping("/comment/bulk")
    public void bulkInsertComment(@RequestBody ArrayList<Comment> comments) {
    	postgreService.insertManyComments(comments);
    }
    
    @DeleteMapping("/comment/delete") 
    public void deleteComment(@RequestParam int commentId) {
    	postgreService.deleteComments(commentId);
    }
    
    @DeleteMapping("/comment/deleteMany")
    public void bulkDeleteComments(@RequestParam int[] commentId ) {
    	postgreService.deleteManyComments(commentId);
    }

    @DeleteMapping("/comment/deleteAll")
    public void deleteAllComments(){
        postgreService.deleteAllComments();
    }

    @GetMapping("/clientTransaction")
    public List<ClientTransaction> getAllClientTransactions() {
        return postgreService.getAllClientTransactions();
    }
    
    @PostMapping("/clientTransaction")
    public void insertClientTransaction(@RequestBody ClientTransaction clientTransaction) {
    	postgreService.insertClientTransaction(clientTransaction);
    }
    
    @PostMapping("/clientTransaction/bulk")
    public void bulkInsertClientTransactions(@RequestBody ArrayList<ClientTransaction> clientTransactions) {
    	postgreService.insertManyClientTransactions(clientTransactions);
    }
    
    @DeleteMapping("/clientTransaction/delete") 
    public void deleteClientTransaction(@RequestParam int id) {
    	postgreService.deleteClientTransactions(id);
    }
    
    @DeleteMapping("/clientTransaction/deleteMany")
    public void bulkDeleteClientTransactions(@RequestParam int[] ids) {
    	postgreService.deleteManyClientTransactions(ids);
    }

    @DeleteMapping("/clientTransaction/deleteAll")
    public void deleteAllClientTransactions(){
        postgreService.deleteAllClientTransactions();
    }
    
    @GetMapping("/clientTansaction/getTransactions")
    public List<ClientTransaction> getTransactionsToProcess() {
        //Get documents on a certain date then sorted in descending order by clientTransaction id
        return postgreService.getClientTransactionsToProcess();

//    	List<Bson> filters = Arrays.asList(
//    			new Document("$match",
//    					new Document("transactionRecievedDate", "0001-01-01")
//    					.append("transactionStatus", new Document("$ne", "C"))
//    					.append("price", 0L)),
//    			new Document("$project", new Document("_id", 0)),
//    			new Document("$sort", new Document("cusip", 1L)
//    						.append("tradeDate", 1L)));
   
    //get all documents with default TransactionReceivedDate, default price, and transactionStatus is not "C". return id, sorted by (cusip, date)
    }
    
    public void updateMappedClientTransPrice() {}
}
