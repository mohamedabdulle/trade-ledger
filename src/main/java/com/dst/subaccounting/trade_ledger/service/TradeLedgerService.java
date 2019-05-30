package com.dst.subaccounting.trade_ledger.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
	public List<MainDocument> findAll(){
		return mongoOperations.findAll(MainDocument.class);
	}
	
	public void removeOne(ObjectId id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		mongoOperations.remove(query,MainDocument.class);
	}
	
	public void insertOne(MainDocument test) {
		mongoOperations.insert(test);
	}
	
	public void update(ObjectId id, Object updateValue, String updateKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		Update update = new Update();
		update.set(updateKey,updateValue);
		
		mongoOperations.updateFirst(query, update, MainDocument.class);
	}	
}
