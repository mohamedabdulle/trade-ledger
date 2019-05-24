package com.ssc.dst.subaccounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ssc.dst.subaccounting.model.MainDocument;
import com.ssc.dst.subaccounting.model.Person;
import com.ssc.dst.subaccounting.service.SubaccountingService;

@RestController
@RequestMapping("/subaccounting")
public class SubaccountingController {
	
	@Autowired
	SubaccountingService subaccountingService;

	@DeleteMapping("/entry")
	public String deleteEntry(@RequestParam String name) {
		return "";
	}

	@DeleteMapping("/document/")
	public String deleteDocument(@RequestBody Person person) {
		return "";
	}

	@GetMapping("/entry")
	public MainDocument getEntry() {
		return subaccountingService.findAll();
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
