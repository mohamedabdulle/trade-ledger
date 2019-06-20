package org.mongo_service;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongo_service.model.ClientTransactionsDocument;

public interface MongoDbOperations {

	List<ClientTransactionsDocument> findAll();

	void removeOne(String id);

	ClientTransactionsDocument insertOne(ClientTransactionsDocument test);

	<T> List<ClientTransactionsDocument> findAll(String key, T value);
	
	<T> void update(String id, String updateKey, T updateValue);
	
	void removeField(String id, String deleteKey);
	
	void update(String id, Document doc);
}
