package com.dst.subaccounting.trade_ledger;
import com.dst.subaccounting.trade_ledger.model.*;


import java.util.List;

import org.bson.types.ObjectId;

public interface MongoDbOperations {
	
<<<<<<< HEAD
	<T> List<T> findAll();
	
	
	
	
	
	
	
=======
List<MainDocument> findAll();
	
	void removeOne(ObjectId id);
	
	void insertOne(MainDocument test);
>>>>>>> c8bc1c90e79a1258b5b6f5452b77027c1d942478

	void update(ObjectId id, Object updateValue, String updateKey);
}
