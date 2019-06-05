package org.mongo_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "database1")
public class Person {

    @Id
    private String id;
    private String name;
    private int age;
    private int weight;
    private int height;

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}