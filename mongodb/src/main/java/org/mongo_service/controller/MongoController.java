package org.mongo_service.controller;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import org.mongo_service.model.ClientTransactionsDocument;
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
	public List<ClientTransactionsDocument> deleteOne(@PathVariable ObjectId id) {
		tradeLedgerService.removeOne(id);
		return tradeLedgerService.findAll();
	}

	@DeleteMapping("/field/{id}")
	public void deleteField(@PathVariable ObjectId id, @RequestParam String deleteKey) {
		tradeLedgerService.removeField(id, deleteKey);
	}

    @GetMapping("/")
    public List<ClientTransactionsDocument> getDocuments(@RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) throws Exception {
        if(startDate == null) {
            return getAllDocuments();
        }
        return getDocumentsInDateRange(startDate, endDate);
    }
    
    private List<ClientTransactionsDocument> getAllDocuments() {
        List<ClientTransactionsDocument> docs =  tradeLedgerService.findAll();
        kafkaTemplate.send(topicName, "getting all docs");
        return docs;
    }
        
    private List<ClientTransactionsDocument> getDocumentsInDateRange(Long startDate, Long endDate) throws Exception {
        if(startDate == null ) {
            throw new Exception("startDate can't be null");
        }
        if(endDate == null) {
            endDate = System.currentTimeMillis();
        }
        List<ClientTransactionsDocument> docs = tradeLedgerService.queryByDateRange(startDate.longValue(), endDate.longValue());
        kafkaTemplate.send(topicName, "got " + docs.size() + " docs between [" + startDate + ", " + endDate + ")");
        return docs;
    }

	//Problem with int/numbers/booleans. 

	@GetMapping("/getDocWithQuery")
	public <T> List<ClientTransactionsDocument> getDocuments(@RequestParam String key, @RequestParam T value) throws Exception{
		Object passedValue = (Object) value;
		List<ClientTransactionsDocument> docs = tradeLedgerService.findAll(key, value); //To find nested fields, simply put field.nestedField
		return docs;
	}

	@PostMapping("/create")
	public List<ClientTransactionsDocument> CreateDocument(@RequestBody ClientTransactionsDocument ClientTransactionsDocument) {
		tradeLedgerService.insertOne(ClientTransactionsDocument);
		return tradeLedgerService.findAll();
	}

	
	//Doesnt deal with integers/numbers/booleans yet. I need to find a way to get this working with them
	@PostMapping("/{id}")
	public <T> void UpdateDocumentFields(@PathVariable ObjectId id, @RequestParam String updateKey, @RequestParam T updateValue) {
		tradeLedgerService.update(id, updateKey, updateValue);
	}
	
	@PostMapping("/BodyRequest/{id}")
	public String updateDocumentWithBody(@PathVariable ObjectId id,@RequestBody ClientTransactionsDocument ClientTransactionsDocument) {
		Document doc = new Document();
		return "";
		
		
		
	}
	
	
}
