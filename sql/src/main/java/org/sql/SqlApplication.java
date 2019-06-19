package org.sql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient     // Enable eureka client. It inherits from @EnableDiscoveryClient.
public class SqlApplication { 

    public static void main(String[] args) {
        SpringApplication.run(SqlApplication.class, args);
    }
    
}
