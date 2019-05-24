package com.ssc.dst.subaccounting.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoDBConfig {

    @Value("${spring.data.mongodb.username}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.uri}")
    private String uri;


//    protected @Override
//    String getDatabaseName() {
//        return database;
//    }
//
//    public @Override
//    MongoClient mongoClient() {
//        return new MongoClient(new ServerAddress(host, port));
////        return new MongoClient(new MongoClientURI(uri));
//    }
//
//    public @Bean
//    MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), database);
//    }

    public @Bean MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(), database);
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
