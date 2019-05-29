package com.dst.subaccounting.trade_ledger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.dst.subaccounting.trade_ledger.MongoDbOperations;
import com.dst.subaccounting.trade_ledger.config.MongoDbConfig;
import com.dst.subaccounting.trade_ledger.model.MainDocument;

@Service
public class TradeLedgerService implements MongoDbOperations {
  
    private MongoOperations mongoOperations;
    
    @Autowired
    public TradeLedgerService(MongoDbConfig mongoClient) {
    	mongoOperations = mongoClient.mongoTemplate();
    }
     
	@Override
	public List<MainDocument> findAll() {
		return mongoOperations.findAll(MainDocument.class);
	}
}
