package com.dst.subaccounting.trade_ledger.controller;

import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dst.subaccounting.trade_ledger.model.MainDocument;
import com.dst.subaccounting.trade_ledger.service.TradeLedgerService;

@RestController
@RequestMapping("/subaccounting")
public class TradeLedgerController {
	
	@Autowired
	TradeLedgerService tradeLedgerService;

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
		return tradeLedgerService.findAll();
	}

	//@GetMapping("/document")
	public String getDocument() throws Exception {
		return "";
	}

	@PostMapping("/document/create")
	public List<MainDocument> CreateDocument(@RequestBody MainDocument mainDocument) {
		tradeLedgerService.insert(mainDocument);
		return tradeLedgerService.findAll();
	}

	@PostMapping("/document/{id}/{updateKey}")
	public List<MainDocument> UpdateDocument(@PathVariable ObjectId id, @PathVariable String updateKey, @RequestBody MainDocument update) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		  map.put("actualpostingdate",update.getActualPostingDate());
		  map.put("agentforfirm",update.getAgentForFirm());
		  Object updateValue = map.get(updateKey);
		  tradeLedgerService.update(id, updateValue, updateKey);
		  return tradeLedgerService.findAll();
	}
}
