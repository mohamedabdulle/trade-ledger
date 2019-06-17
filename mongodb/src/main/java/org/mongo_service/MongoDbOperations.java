package org.mongo_service;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongo_service.model.ClientTransactionsDocument;

public interface MongoDbOperations {

	List<ClientTransactionsDocument> findAll();

	void removeOne(ObjectId id);

	ClientTransactionsDocument insertOne(ClientTransactionsDocument test);

	<T> List<ClientTransactionsDocument> findAll(String key, T value);
	
	<T> void update(ObjectId id, String updateKey, T updateValue);
	
	void removeField(ObjectId id, String deleteKey);
	
	void update(ObjectId id, Document doc);
}
