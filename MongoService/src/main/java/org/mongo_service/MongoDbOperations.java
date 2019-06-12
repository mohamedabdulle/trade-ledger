package org.mongo_service;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongo_service.model.MainDocument;
import org.mongo_service.model.setup.ClientTransactionsDocument;

public interface MongoDbOperations {

	List<ClientTransactionsDocument> findAll();

	void removeOne(ObjectId id);

	void insertOne(ClientTransactionsDocument test);

	List<ClientTransactionsDocument> findAll(String key, Object value);
	
	void update(ObjectId id, List<String> updateKey, List<Object> updateValue);
	
	void removeField(ObjectId id, String deleteKey);
}
