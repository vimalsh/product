package com.deadly.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deadly.java8.topics.DateTimeAPI;
import com.deadly.java8.topics.JavaStreamAPI;
import com.deadly.java8.topics.OptionalClass;

@SpringBootApplication
public class Java8Application implements CommandLineRunner{

	@Autowired
	JavaStreamAPI javaStreamapi;
	
	@Autowired
	DateTimeAPI dateTimeAPI;
	
	@Autowired
	OptionalClass optionalClass;
	
	public static void main(String[] args) {
		SpringApplication.run(Java8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List names = new ArrayList();
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
	      names.forEach(System.out::println);
	      names.forEach((name)->System.out.println(name));
//		reduce operator
//		Integer result = Arrays.asList(1,2,3,4,6,5).stream().reduce(0,(a,b)-> a+b);
//		System.out.println("result"+result);
		//To Run the Java Stream API Method
//		javaStreamapi.run();
		//To Run the Date And Time API Method
//		dateTimeAPI.run();
		//To Run the Optional Class API Method
//		optionalClass.run();
	}

}
