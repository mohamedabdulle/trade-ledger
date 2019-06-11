package org.mongo_service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.*;

import org.mongo_service.model.MainDocument;
import org.mongo_service.service.MongoService;

@RestController
@RequestMapping("/subaccounting")
public class MongoController {
	
	@Autowired
	MongoService tradeLedgerService;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
    @Value(value = "${loggingTopicName}")
    private String topicName;
	
	@DeleteMapping("/document/{id}")
	public List<MainDocument> deleteOne(@PathVariable ObjectId id) {
		tradeLedgerService.removeOne(id);
		return tradeLedgerService.findAll();
	}

	@DeleteMapping("/document/field/{id}")
	public void deleteField(@PathVariable ObjectId id, @RequestParam String deleteKey) {
		tradeLedgerService.removeField(id, deleteKey);
	}

	@GetMapping("/document")
	public List<MainDocument> getAll() {    
		List<MainDocument> docs =  tradeLedgerService.findAll();
		kafkaTemplate.send(topicName, "getting all docs");
		return docs;
	}

	//Problem with int/numbers/booleans. 
	@GetMapping("/document/getDocWithQuery")
	public List<MainDocument> getDocuments(@RequestParam String key, @RequestParam String value) throws Exception{
		List<MainDocument> docs = tradeLedgerService.findAll(key,value); //To find nested fields, simply put field.nestedField
		return docs;
	}

	@PostMapping("/document/create")
	public List<MainDocument> CreateDocument(@RequestBody MainDocument mainDocument) {
		tradeLedgerService.insertOne(mainDocument);
		return tradeLedgerService.findAll();
	}

		
	//Doesnt deal with integers/numbers/booleans yet. I need to find a way to get this working with them
	@PostMapping("/document/{id}")
	public void UpdateDocumentFields(@PathVariable ObjectId id, @RequestParam("updateKey") List<String> updateKey, @RequestParam("updateValue") List<String> updateValue) {
		List<Object> objectUpdateValue = new ArrayList<Object>(updateValue);
		tradeLedgerService.update(id, updateKey, objectUpdateValue);
	}
}
