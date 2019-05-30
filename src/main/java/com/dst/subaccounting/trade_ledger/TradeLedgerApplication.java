package com.dst.subaccounting.trade_ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class TradeLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeLedgerApplication.class, args);
	}
	
	@KafkaListener(topics = "mongoRequests", groupId = "${kafka.groupId}")
	public void listen(String message) {
	    System.out.println("Received Messasge: " + message);
	}
}
