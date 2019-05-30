package com.dst.subaccounting.trade_ledger;

import com.dst.subaccounting.trade_ledger.model.*;

import java.util.List;
import org.bson.types.ObjectId;

public interface MongoDbOperations {

	List<MainDocument> findAll();

	void removeOne(ObjectId id);

	void insert(MainDocument mainDocument);

	void update(ObjectId id, Object updateValue, String updateKey);
}
