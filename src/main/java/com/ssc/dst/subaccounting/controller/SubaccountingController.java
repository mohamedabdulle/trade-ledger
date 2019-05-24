package com.ssc.dst.subaccounting.controller;

import com.ssc.dst.subaccounting.config.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import com.ssc.dst.subaccounting.model.Person;

@RestController
@RequestMapping("/subaccounting")
public class SubaccountingController {

	@DeleteMapping("/entry")
	public Person deleteEntry(@RequestParam String name) {
		return ;
	}

	@DeleteMapping("/document/")
	public Person deleteDocument(@RequestBody Person person) {
		return person;
	}

	@GetMapping("/entry")
	public void getEntry() throws Exception {
		MongoOperations mongoOperations = mongoClient.mongoTemplate();
		
		//Person person = new Person("amy1", "24");
		//mongoOperations.save(person);
		
		//mongoOperations.remove(new Query(Criteria.where("name").is("amy1")), Person.class);
		//System.out.println(mongoOperations.findOne(new Query(Criteria.where("name").is("")), Person.class).toString());
		System.out.println(mongoOperations.findAll(Person.class).toString());
	}

	@GetMapping("/document")
	public void getDocument() throws Exception {
		MongoOperations mongoOperations = mongoClient.mongoTemplate();

		//Person person = new Person("amy1", "24");
		//mongoOperations.save(person);

		//mongoOperations.remove(new Query(Criteria.where("name").is("amy1")), Person.class);
		//System.out.println(mongoOperations.findOne(new Query(Criteria.where("name").is("")), Person.class).toString());
		System.out.println(mongoOperations.findAll(Person.class).toString());
	}

	@PostMapping("/entry")
	public Person PostEntry(@RequestParam String name) {
		return ;
	}

	@PostMapping("/document/")
	public Person PostDocument(@RequestBody Person person) {
		return person;
	}
}
