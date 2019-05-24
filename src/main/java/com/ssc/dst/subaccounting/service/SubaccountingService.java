package com.ssc.dst.subaccounting.service;

import com.ssc.dst.subaccounting.MongoDbOperations;
import com.ssc.dst.subaccounting.config.MongoDbConfig;
import com.ssc.dst.subaccounting.model.MainDocument;
import com.ssc.dst.subaccounting.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

@Service
public class SubaccountingService implements MongoDbOperations {
  
    private MongoOperations mongoOperations;
    
    @Autowired
    public SubaccountingService(MongoDbConfig mongoClient) {
    	mongoOperations = mongoClient.mongoTemplate();
    }
     
	@Override
	public MainDocument findAll() {
		return mongoOperations.findAll(MainDocument.class).get(0);
	}

}
