package com.dst.subaccounting.trade_ledger.controller;

import java.util.HashMap;
import java.util.List;

import com.dst.subaccounting.trade_ledger.model.setup.ClientTransactionsDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dst.subaccounting.trade_ledger.model.MainDocument;
import com.dst.subaccounting.trade_ledger.service.TradeLedgerService;

@RestController
@RequestMapping("/trade-ledger")
public class TradeLedgerController {
	
	@Autowired
	TradeLedgerService tradeLedgerService;

	@GetMapping()
	public List<ClientTransactionsDocument> getAll() {
		return tradeLedgerService.findAll();
	}
}
