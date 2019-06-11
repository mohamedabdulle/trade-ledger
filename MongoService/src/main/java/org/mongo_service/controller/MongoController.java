package org.mongo_service.controller;

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

	@DeleteMapping("/document/")
	public String deleteDocument(@RequestBody MainDocument mainDocument) {
		return "";
	}

	@GetMapping("/document")
	public List<MainDocument> getAll() {    
		List<MainDocument> docs =  tradeLedgerService.findAll();
		kafkaTemplate.send(topicName, "getting all docs");
		return docs;
	}

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

	@PostMapping("/document/{id}")
	public void UpdateDocument(@PathVariable ObjectId id, @RequestParam String updateKey, @RequestParam String updateValue) {
				  
		tradeLedgerService.update(id, updateValue, updateKey);
	}
	@PostMapping("/document/MultiFields/{id}")
	public void UpdateDocumentFields(@PathVariable ObjectId id, @RequestParam List<String> updateKey, @RequestParam List<Object> updateValue) {
				  
		tradeLedgerService.updateFields(id, updateKey, updateValue);
	}
}
