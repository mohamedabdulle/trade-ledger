package org.KafkaMicroservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaMessageHandler {
    
    @Autowired
    private RestTemplate restTemplate;

    public void handleKafkaMessage(Object message) {
        String messageString = message.toString().trim().toLowerCase();
            switch(messageString) {
                case("get all"): {
                    String address = "http://mongo-service/";
                    String url = address + "subaccounting/document/";
                    @SuppressWarnings("unchecked")
                    List<Object> documents = restTemplate.getForObject(url, List.class);
                    System.out.println(documents);
                }
            }            
        

    }

}