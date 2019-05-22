package com.ssc.dst.subaccounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssc.dst.subaccounting.config.DatabaseInstanceConfig;
import com.ssc.dst.subaccounting.config.RepositoryConfig;
import com.ssc.dst.subaccounting.model.Person;

@RestController
public class SubaccountingController {
	
	@Autowired
	private DatabaseInstanceConfig mongoClient;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/get")
	public void get() throws Exception {
		MongoOperations mongoOperations = mongoClient.mongoTemplate();
		
		//Person person = new Person("amy1", "24");
		//mongoOperations.save(person);
		
		//mongoOperations.remove(new Query(Criteria.where("name").is("amy1")), Person.class);
		//System.out.println(mongoOperations.findOne(new Query(Criteria.where("name").is("")), Person.class).toString());
		System.out.println(mongoOperations.findAll(Person.class).toString());
	}
}
