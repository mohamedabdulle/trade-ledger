package com.ssc.dst.subaccounting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database1")
public class Person {
	  @Id	
	  private String id;
	  
	  private String name;
	  private String age;

	  public Person(String name, String age) {
	    this.name = name;
	    this.age = age;
	  }

	  public String getId() {
	    return id;
	  }
	  public String getName() {
	    return name;
	  }
	  public String getAge() {
	    return age;
	  }

	  @Override
	  public String toString() {
	    return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	  }
	}