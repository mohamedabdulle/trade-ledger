package org.KafkaMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
@EnableEurekaClient     // Enable eureka client. It inherits from @EnableDiscoveryClient.
public class KafkaServiceApplication {
    
    @Autowired
    private KafkaMessageHandler handler;
   
    public static void main(String[] args) {
        SpringApplication.run(KafkaServiceApplication.class, args);
    }
    
    @KafkaListener(topics = "mongoRequests", groupId = "${kafka.groupId}")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
        handler.handleKafkaMessage(message);
    }
}
