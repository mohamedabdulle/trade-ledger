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
import org.mongo_service.model.MainDocument;

@Service
public class MongoService implements MongoDbOperations {

    private MongoOperations mongoOperations;

    @Autowired
    public MongoService(MongoDbConfig mongoClient) {
        mongoOperations = mongoClient.mongoTemplate();
    }

    @Override
    public List<MainDocument> findAll() {
        return mongoOperations.findAll(MainDocument.class);
    }

    public void removeField(ObjectId id, String deleteKey) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set(deleteKey, null);

        mongoOperations.updateFirst(query, update, MainDocument.class);
    }

    public void removeOne(ObjectId id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        mongoOperations.remove(query, MainDocument.class);
    }

    public void insertOne(MainDocument mainDocument) {
        mongoOperations.insert(mainDocument);
    }

    public List<MainDocument> findAll(String key, String value) {
//        MainDocument doc = new MainDocument();
//        insertOne(doc);
        Query query = new Query();
        query.addCriteria(Criteria.where(key).is(value));
        return mongoOperations.find(query, MainDocument.class);

    }

    public List<MainDocument> queryByDateRange(long start, long end) {
        return this.queryByRangeWithField(start, end, "actualpostingdate");
    }

    /* To DO: ADD ASSERTION THAT FIELD IS VALID */
    private List<MainDocument> queryByRangeWithField(Object start, Object end, String fieldName) {
        Query query = new Query();

        query.addCriteria(
                // new Criteria().andOperator(
                Criteria.where(fieldName).gte(start)// ,
        // Criteria.where(fieldName).lt(end)
        // )
        );
        System.out.println(query);

        return mongoOperations.find(query, MainDocument.class);
    }

    public void update(ObjectId id, Object updateValue, String updateKey) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        update.set(updateKey, updateValue);

        mongoOperations.updateFirst(query, update, MainDocument.class);

    }

    public void update(ObjectId id, List<String> updateKey, List<Object> updateValue) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        int i = 0;
        int lastIndex = updateKey.size();
        while (i < lastIndex) {
            update.set(updateKey.get(i), updateValue.get(i));
            i++;
        }

        mongoOperations.updateFirst(query, update, MainDocument.class);
    }
}
