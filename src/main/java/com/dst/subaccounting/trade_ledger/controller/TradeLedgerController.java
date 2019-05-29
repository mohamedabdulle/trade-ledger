package com.dst.subaccounting.trade_ledger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dst.subaccounting.trade_ledger.model.MainDocument;
import com.dst.subaccounting.trade_ledger.model.Person;
import com.dst.subaccounting.trade_ledger.service.TradeLedgerService;

@RestController
@RequestMapping("/subaccounting")
public class TradeLedgerController {
	
	@Autowired
	TradeLedgerService tradeLedgerService;

	@DeleteMapping("/entry")
	public String deleteEntry(@RequestParam String name) {
		return "";
	}

	@DeleteMapping("/document/")
	public String deleteDocument(@RequestBody Person person) {
		return "";
	}

	@GetMapping("/entry")
	public List<MainDocument> getEntry() {
		return tradeLedgerService.findAll();
	}

	@GetMapping("/document")
	public String getDocument() throws Exception {
		return "";
	}

	@PostMapping("/entry")
	public String PostEntry(@RequestParam String name) {
		return "";
	}

	@PostMapping("/document/")
	public String PostDocument(@RequestBody Person person) {
		return "";
	}
}
