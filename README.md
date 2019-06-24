# Trade Ledger

A POC to test out listening to a Kafka topic to send requests to a MongoDB using a Microservice Architecture with Spring Boot.

## Quick Start

1. Run Kafka

Refer to https://kafka.apache.org/quickstart.

a) Start Zookeeper for Kafka 
```
bin/windows/zookeeper-server-start.bat config/zookeeper.properties
```

b) Start Kafka server
```
bin/kafka-server-start.sh config/server.properties
```

c) Create Kakfa topics
This only needs to be done once
```
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic mongoRequests
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic logging
```

2. Start Eureka server by running EurekaServerApplication.java as a Java Application

3. Start Zuul server by running ZuulApplication.java as a Java Application

4. Start MongoServiceApplication.java as a Java Application

5. (Optional) Start KafkaServiceApplication.java as a Java Application to listen to requests from the mongoRequests kafka topic

### Lombok

Setting up Lombok:

https://www.baeldung.com/lombok-ide

## Authors
Sahan De Almeida
Stephen Lin
Mohamed Abdulle