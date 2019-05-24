package com.ssc.dst.subaccounting.service;

import com.ssc.dst.subaccounting.MongoDbOperations;
import com.ssc.dst.subaccounting.config.MongoDbConfig;
import com.ssc.dst.subaccounting.model.MainDocument;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class SubaccountingService implements MongoDbOperations {
  
    private MongoOperations mongoOperations;
    
    @Autowired
    public SubaccountingService(MongoDbConfig mongoClient) {
    	mongoOperations = mongoClient.mongoTemplate();
    }
     
	@Override
	public List<MainDocument> findAll() {
		return mongoOperations.findAll(MainDocument.class);
	}
}
