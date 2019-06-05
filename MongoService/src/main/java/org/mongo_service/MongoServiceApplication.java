package org.mongo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class MongoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoServiceApplication.class, args);
    }
    
}