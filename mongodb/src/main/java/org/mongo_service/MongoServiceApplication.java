package org.mongo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableEurekaClient     // Enable eureka client. It inherits from @EnableDiscoveryClient.
public class MongoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoServiceApplication.class, args);
    }
    
}