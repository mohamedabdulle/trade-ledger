package com.dst.subaccounting.postgre.controller;

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
    public List<Comment> getAll() {
        return postgreService.getAll();
    }
    
    @PostMapping("/comment")
    public void insert(@RequestBody Comment comment) {
    	postgreService.insertComment(comment);
    }
    
    @PostMapping("/comment/bulk")
    public void bulkInsert(@RequestBody ArrayList<Comment> comments) {
    	postgreService.insertManyComment(comments);
    }
    
    @DeleteMapping("/comment/delete") 
    public void delete(@RequestParam int commentId) {
    	postgreService.deleteComment(commentId);
    }
    
    
    @DeleteMapping("/comment/deleteMany")
    public void bulkDelete(@RequestParam int[] commentId ) {
    	postgreService.deleteManyComment(commentId);
    }
    

    @DeleteMapping("/comment/deleteAll")
    public void deleteAll(){
        postgreService.deleteAll();
    }
}
