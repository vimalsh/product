package com.deadly.java8.topics;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deadly.java8.pojo.Movie;

@Service
public class OptionalClass {

	public void run() {
		Movie movie = new Movie(null,"Vasanth",2022,50,Arrays.asList("ASD","ZXC"));
		Optional<String> movieName = Optional.ofNullable(movie.getMovieName());
		System.out.println(movieName.orElse(movie.getActor()));  //orElse
		if(movieName.isPresent()) { //isPresent
			System.out.println(movieName.get()); //get
			System.out.println("Movie Name is There");
		}else {
			System.out.println("Null");
		}
	}
	
}
