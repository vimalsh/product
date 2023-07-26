package com.deadly.java8.topics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.deadly.java8.pojo.Movie;

@Service
public class JavaStreamAPI {

	public void run() {
		System.out.println("Java 8 Application starts");
		LocalDate localDate = LocalDate.now();
		List<Movie> movieList = new ArrayList<Movie>();
		movieList = Arrays.asList(
				new Movie("Rockey","Vasanth",2022,50,Arrays.asList("ASD","ZXC")),
				new Movie("Beast","Vijay",2022,200,Arrays.asList("ala","beast mode")),
				new Movie("vikram","Kamal",2022,450,Arrays.asList("pathala","Ghost")),
				new Movie("RRR","NTR",2021,100,Arrays.asList("nanba","natu")),
				new Movie("Arusan","Mr.D",2020,100,Arrays.asList("asuran","karupu"))
				);
//		Lambda Expression
		
//		Method Reference
		List<String> mfMovieNames = movieList.stream().map(Movie::getMovieName).collect(Collectors.toList());
		System.out.println("mfMovieNames==="+mfMovieNames);
//		Functional Reference
		
//		Java Streams collect
		try {
//			Creational Operator
//			 Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).distinct().parallel();
//			 Intermediate Operator
			List<String> filterResult = movieList.stream()
					.filter((movie)->movie.getYear()==2022) //filter
					.map((movie)->movie.getSongs())  //map
					.flatMap(songs-> songs.stream())
					.limit(10) //limit
					.distinct() //distinct
					.peek((movie)-> System.out.println("peekmovie=="+movie)) //peek
					.sorted() //sorted
					.collect(Collectors.toList());
			System.out.println("filterResult==="+filterResult);
//			Terminal Operator
//			 stream.forEach((val)->System.out.println("val=="+val)); //forEach
//			 stream.forEachOrdered((val)->System.out.println("val=="+val)); //forEachOrdered
//			 System.out.println("count==="+stream.count()); //count
//			 System.out.println("distinct==="+stream.distinct()); //distinct
//			 System.out.println("reduce sum==="+stream.reduce(0,(a,b)-> a+b)); //reduce
//			 Boolean anyMatchFlag = stream.anyMatch(val-> val==1); //anyMatch
//			 System.out.println("anyMatchFlag===="+anyMatchFlag);
//			 Boolean allMatchFlag =  stream.allMatch(val-> val==1); //allMatch
//			 System.out.println("allMatchFlag===="+allMatchFlag);
//			 Boolean noneMatchFlag =  stream.noneMatch(val-> val==1);  //noneMatch
//			 System.out.println("noneMatchFlag===="+noneMatchFlag);
//			 Optional<Integer> a = stream.findAny(); //findAny
//			 Optional<Integer> a = stream.findFirst(); //findFirst
//			 System.out.println(a);
//			 System.out.println(stream.min((a,b)-> a-b)); // min
//			 System.out.println(stream.max((a,b)-> a-b)); // max
//			 collect() condition
//			1.Get list of movie name and add it to list
			List<String> listMovieNames = movieList.stream().map((movie)->movie.getMovieName()).collect(Collectors.toList());
			System.out.println("listMovieNames==="+listMovieNames);
//			2.Get list of movie name and add it to set(Remove the duplicates)
			Set<String> setMovieNames = movieList.stream().map((movie)->movie.getMovieName()).collect(Collectors.toSet());
			System.out.println("setMovieNames==="+setMovieNames);
//			3.Joining the moviename with comma separated string
			String joinMovieNames = movieList.stream().map((movie)->movie.getMovieName()).collect(Collectors.joining("','", "'", "'"));
			System.out.println("joinMovieNames==="+joinMovieNames);
//			4.Grouping movies based on released year
			Map<Integer, List<Movie>> grpMovieName = movieList.stream().collect(Collectors.groupingBy(Movie::getYear));
			System.out.println("grpMovieName=="+grpMovieName);
//			5.Find the movie collection average
			Double collectionAvg = movieList.stream().collect(Collectors.averagingDouble(Movie::getCollection));
			System.out.println("collectionAvg=="+collectionAvg);
//			6.Find the movie count
			Long movieCount = movieList.stream().collect(Collectors.counting());
			System.out.println("movieCount=="+movieCount);
//			7.Find the total movie collection	
			DoubleSummaryStatistics totalCollection = movieList.stream().collect(Collectors.summarizingDouble(Movie::getCollection));
			System.out.println("totalCollection=="+totalCollection);
			System.out.println("sum=="+totalCollection.getSum());
			System.out.println("average=="+totalCollection.getAverage());
			System.out.println("count=="+totalCollection.getCount());
			System.out.println("max=="+totalCollection.getMax());
			System.out.println("min=="+totalCollection.getMin());
//			8.split the list of movies into 2 seperate list based on criteria (collection > 150) --> partitionBy
			Map<Boolean, List<Movie>> partitionMovie = movieList.stream().collect(Collectors.partitioningBy((movie)->movie.getCollection() >= 150));
			partitionMovie.forEach((k,v)->System.out.println("key===="+k+"===value==="+v));
//			9.Grouping movies based on released year and count
			Map<Integer, Long> grpCountMovie = movieList.stream().collect(Collectors.groupingBy(Movie::getYear, Collectors.counting()));
			System.out.println("grpCountMovie=="+grpCountMovie);
//			10.Grouping movies based on released year and movieName in value
			Map<Integer, List<String>> result = movieList.stream().collect(Collectors.groupingBy(Movie::getYear,Collectors.mapping(Movie::getMovieName, Collectors.toList())));
			System.out.println("result==="+result);
			Map<Integer, Map<String, String>> mapResult = movieList.stream().collect(Collectors.groupingBy(Movie::getYear,Collectors.toMap(Movie::getActor, Movie::getMovieName)));
			System.out.println("mapResult==="+mapResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
