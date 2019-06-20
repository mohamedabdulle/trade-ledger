package com.dst.subaccounting.postgre.controller;

import com.dst.subaccounting.postgre.model.Comment;
import com.dst.subaccounting.postgre.service.PostgreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
