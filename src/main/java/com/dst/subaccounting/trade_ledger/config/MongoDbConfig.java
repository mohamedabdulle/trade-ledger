package com.dst.subaccounting.trade_ledger.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.List;

@Configuration
public class MongoDbConfig {

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("#{'${spring.data.mongodb.collection}'.split(',')}")
	private List<String> collectionList;

	public @Bean MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(new MongoClient(host), database);
	}

	public @Bean MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		for (String collection: collectionList){
			if (mongoTemplate.getCollectionNames().contains(collection)) {
				mongoTemplate.dropCollection(collection);
				mongoTemplate.createCollection(collection);
			} else {
				mongoTemplate.createCollection(collection);
			}
		}
		return mongoTemplate;
	}
}
