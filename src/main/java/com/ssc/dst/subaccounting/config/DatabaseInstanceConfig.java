package com.ssc.dst.subaccounting.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class DatabaseInstanceConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.username}")
	private String user;
	
	@Value("${spring.data.mongodb.database}")
	private String db;
	
	@Value("${spring.data.mongodb.password}")
	private String pwd;

	@Value("${spring.data.mongodb.host}")
	private String host;
	
	@Value("${spring.data.mongodb.port}")
	private int port;
	

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "database";
	}

	@Override
	public MongoClient mongoClient() {
		 return new MongoClient(new ServerAddress(host, port));
		//return new MongoClient(new MongoClientURI("mongodb://127.0.0.1"));
	}
	
	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "database");
	}
}
