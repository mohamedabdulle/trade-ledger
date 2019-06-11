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
@RequestMapping("/document/")
public class MongoController {
	
	@Autowired
	MongoService tradeLedgerService;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
    @Value(value = "${loggingTopicName}")
    private String topicName;
	
	@DeleteMapping("/{id}")
	public List<MainDocument> deleteOne(@PathVariable ObjectId id) {
		tradeLedgerService.removeOne(id);
		return tradeLedgerService.findAll();
	}

	@DeleteMapping("/field/{id}")
	public void deleteField(@PathVariable ObjectId id, @RequestParam String deleteKey) {
		tradeLedgerService.removeField(id, deleteKey);
	}

    @GetMapping("/")
    public List<MainDocument> getDocuments(@RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) throws Exception {
        if(startDate == null) {
            return getAllDocuments();
        }
        return getDocumentsInDateRange(startDate, endDate);
    }
    
    private List<MainDocument> getAllDocuments() {
        List<MainDocument> docs =  tradeLedgerService.findAll();
        kafkaTemplate.send(topicName, "getting all docs");
        return docs;
    }
        
    private List<MainDocument> getDocumentsInDateRange(Long startDate, Long endDate) throws Exception {
        if(startDate == null ) {
            throw new Exception("startDate can't be null");
        }
        if(endDate == null) {
            endDate = System.currentTimeMillis();
        }
        List<MainDocument> docs = tradeLedgerService.queryByDateRange(startDate.longValue(), endDate.longValue());
        kafkaTemplate.send(topicName, "got " + docs.size() + " docs between [" + startDate + ", " + endDate + ")");
        return docs;
    }

	//Problem with int/numbers/booleans. 

	@GetMapping("/document/getDocWithQuery")
	public List<MainDocument> getDocuments(@RequestParam String key, @RequestParam Integer value) throws Exception{
		Object passedValue = (Object) value;
		List<MainDocument> docs = tradeLedgerService.findAll(key,passedValue); //To find nested fields, simply put field.nestedField
		return docs;
	}

	@PostMapping("/create")
	public List<MainDocument> CreateDocument(@RequestBody MainDocument mainDocument) {
		tradeLedgerService.insertOne(mainDocument);
		return tradeLedgerService.findAll();
	}

	
	//Doesnt deal with integers/numbers/booleans yet. I need to find a way to get this working with them
	@PostMapping("/{id}")
	public void UpdateDocumentFields(@PathVariable ObjectId id, @RequestParam("updateKey") List<String> updateKey, @RequestParam("updateValue") List<String> updateValue) {
		List<Object> objectUpdateValue = new ArrayList<Object>(updateValue);
		tradeLedgerService.update(id, updateKey, objectUpdateValue);
	}
}
