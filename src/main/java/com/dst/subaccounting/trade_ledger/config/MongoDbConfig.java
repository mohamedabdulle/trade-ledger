package com.dst.subaccounting.trade_ledger.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoDbConfig {

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.database}")
	private String database;

	public @Bean MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(new MongoClient(host), database);
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}
}
