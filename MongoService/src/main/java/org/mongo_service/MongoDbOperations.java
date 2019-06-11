package org.mongo_service;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongo_service.model.MainDocument;

public interface MongoDbOperations {

	List<MainDocument> findAll();

	void removeOne(ObjectId id);

	void insertOne(MainDocument test);

	List<MainDocument> findAll(String key, Object value);
	
	void update(ObjectId id, List<String> updateKey, List<Object> updateValue);
	
	void removeField(ObjectId id, String deleteKey);
}
