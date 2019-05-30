package com.dst.subaccounting.trade_ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kafka.utils.immutable;

@SpringBootApplication
public class TradeLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeLedgerApplication.class, args);
	}
	
}
