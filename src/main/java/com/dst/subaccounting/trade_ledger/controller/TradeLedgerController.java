package com.dst.subaccounting.trade_ledger.controller;

import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.*;

import com.dst.subaccounting.trade_ledger.model.MainDocument;
import com.dst.subaccounting.trade_ledger.model.Person;
import com.dst.subaccounting.trade_ledger.service.TradeLedgerService;

@RestController
@RequestMapping("/subaccounting")
public class TradeLedgerController {
	
	@Autowired
	TradeLedgerService tradeLedgerService;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
    @Value(value = "${mongoRequestTopicName}")
    private String topicName;
	
	@DeleteMapping("/document/{id}")
	public void deleteOne(@PathVariable ObjectId id) {
		tradeLedgerService.removeOne(id);	
	}

	@DeleteMapping("/document/")
	public String deleteDocument(@RequestBody Person person) {
		return "";
	}

	@GetMapping("/document")
	public List<MainDocument> getAll() {    
		List<MainDocument> docs =  tradeLedgerService.findAll();
		kafkaTemplate.send(topicName, "getting all docs");
		return docs;
	}

	//@GetMapping("/document")
	public String getDocument() throws Exception {
		return "";
	}

	@PostMapping("/document/create")
	public void CreateDocument(@RequestBody MainDocument test) {
		tradeLedgerService.insertOne(test);
	}

	@PostMapping("/document/{id}/{updateKey}")
	public void UpdateDocument(@PathVariable ObjectId id, @PathVariable String updateKey, @RequestBody MainDocument update) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		  map.put("actualpostingdate",update.getActualPostingDate());
		  map.put("agentforfirm",update.getAgentForFirm());
		  Object updateValue = map.get(updateKey);
		  
		  tradeLedgerService.update(id, updateValue, updateKey);
	}
}
