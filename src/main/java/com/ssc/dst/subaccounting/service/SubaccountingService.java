package com.ssc.dst.subaccounting.service;

import com.ssc.dst.subaccounting.MongoDBOperations;
import com.ssc.dst.subaccounting.config.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubaccountingService implements MongoDBOperations {

    @Autowired
    private MongoDBConfig mongoClient;
}
