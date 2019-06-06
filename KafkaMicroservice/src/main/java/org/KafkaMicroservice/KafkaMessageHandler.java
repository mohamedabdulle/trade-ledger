package org.KafkaMicroservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

public class KafkaMessageHandler {
    @Autowired
    private RestTemplate restTemplate;

    public void handleKafkaMessage(Object message) {
        String messageString = message.toString().trim().toLowerCase();
        try {
            switch(messageString) {
                case("get all"): {
                    @SuppressWarnings("unchecked")
                    List<Object> documents = restTemplate.getForObject("http://localhost:8400/subaccounting/document/", List.class);
                    System.out.println(documents);
                }
            }            
        }
        catch(Exception error) {
            System.out.println("couldn't handle kafka message");
            error.printStackTrace();
        }

    }

}