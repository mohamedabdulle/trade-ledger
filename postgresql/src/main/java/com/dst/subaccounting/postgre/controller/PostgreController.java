package com.dst.subaccounting.postgre.controller;

import com.dst.subaccounting.postgre.model.ClientTransaction;
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

    }
    
    public void updateMappedClientTransPrice() {}
}
