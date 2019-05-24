package com.ssc.dst.subaccounting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.util.Assert;

@Configuration
public class RepositoryConfig {
	
//	@Autowired
//	private DatabaseInstanceConfig mongoClient;
//
//	@Autowired
//	public @Bean MongoDbFactory mongoDbFactory(DatabaseInstanceConfig mongoClient) {
//		Assert.notNull(mongoClient, "MongoClient must not be null");
//		return new SimpleMongoDbFactory(mongoClient.mongoClient(), "database");
//		}
//
//	public @Bean MongoTemplate mongoTemplate() {
//		return new MongoTemplate(mongoClient.mongoClient(), "database");
//	 	}
}
