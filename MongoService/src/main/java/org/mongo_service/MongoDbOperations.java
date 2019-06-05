package org.mongo_service;


import java.util.List;

import org.bson.types.ObjectId;
import org.mongo_service.model.MainDocument;

public interface MongoDbOperations {
	
List<MainDocument> findAll();
	
	void removeOne(ObjectId id);
	
	void insertOne(MainDocument test);

	void update(ObjectId id, Object updateValue, String updateKey);
}