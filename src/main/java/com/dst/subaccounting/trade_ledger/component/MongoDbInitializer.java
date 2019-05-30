package com.dst.subaccounting.trade_ledger.component;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.dst.subaccounting.trade_ledger.config.MongoDbConfig;
import com.dst.subaccounting.trade_ledger.model.MainDocument;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MongoDbInitializer implements ApplicationRunner {

	@Autowired
	MongoDbConfig mongoDbConfig;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		MainDocument document = new ObjectMapper()
				.readValue(new ClassPathResource("mongodb/db/maindocument.json").getFile(), MainDocument.class);
		
		MongoOperations mongoOperations = mongoDbConfig.mongoTemplate();
		mongoOperations.insert(document);
	}

}
