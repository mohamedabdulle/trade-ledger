package org.mongo_service.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import org.mongo_service.MongoDbOperations;
import org.mongo_service.config.MongoDbConfig;
import org.mongo_service.model.ClientTransactionsDocument;

@Service
public class MongoService implements MongoDbOperations {

    private MongoOperations mongoOperations;

    @Autowired
    public MongoService(MongoDbConfig mongoClient) {
        mongoOperations = mongoClient.mongoTemplate();
    }

    @Override
	public List<ClientTransactionsDocument> findAll() {
		return mongoOperations.findAll(ClientTransactionsDocument.class);
	}

	public void removeField(ObjectId id, String deleteKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set(deleteKey,null);
		
		mongoOperations.updateFirst(query, update, ClientTransactionsDocument.class);
	}

	public void removeOne(ObjectId id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		mongoOperations.remove(query, ClientTransactionsDocument.class);
	}

	public void insertOne(ClientTransactionsDocument mainDocument) {
		mongoOperations.insert(mainDocument);
	}

    public List<ClientTransactionsDocument> findAll(String key, String value) {
//        MainDocument doc = new MainDocument();
//        insertOne(doc);
        Query query = new Query();
        query.addCriteria(Criteria.where(key).is(value));
        return mongoOperations.find(query, ClientTransactionsDocument.class);

    }

    public List<ClientTransactionsDocument> queryByDateRange(long start, long end) {
        return this.queryByRangeWithField(start, end, "actualpostingdate");
    }

    /* To DO: ADD ASSERTION THAT FIELD IS VALID */
    private List<ClientTransactionsDocument> queryByRangeWithField(Object start, Object end, String fieldName) {
        Query query = new Query();

        query.addCriteria(
                 new Criteria().andOperator(
                Criteria.where(fieldName).gte(start),
         Criteria.where(fieldName).lt(end)
         )
        );
        System.out.println(query);

        return mongoOperations.find(query, ClientTransactionsDocument.class);
    }

    public void update(ObjectId id, Object updateValue, String updateKey) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        update.set(updateKey, updateValue);

        mongoOperations.updateFirst(query, update, ClientTransactionsDocument.class);

    }

	
	public <T> List<ClientTransactionsDocument> findAll(String key, T value){
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoOperations.find(query,ClientTransactionsDocument.class);
		
	}
	
	public <T> void update(ObjectId id, String updateKey, T updateValue) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		Update update = new Update();
		update.set(updateKey, updateValue);
		
		mongoOperations.updateFirst(query, update, ClientTransactionsDocument.class);
	}
	
	public void update(ObjectId id, ClientTransactionsDocument cTD) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		Update update = new Update();
		//update.fromDocument(cTD);
		
	}
}
