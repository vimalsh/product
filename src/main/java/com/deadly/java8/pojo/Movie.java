package com.deadly.java8.pojo;

import java.util.List;

public class Movie {

	private String movieName;
	
	private String actor;
	
	private int year;
	
	private double collection;
	
	private List<String> songs;

	public Movie(String movieName, String actor, int year, double collection, List<String> songs) {
		this.movieName = movieName;
		this.actor = actor;
		this.year = year;
		this.collection = collection;
		this.songs = songs;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCollection() {
		return collection;
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	public List<String> getSongs() {
		return songs;
	}

	public void setSongs(List<String> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", actor=" + actor + ", year=" + year + ", collection=" + collection
				+ ", songs=" + songs + ", getMovieName()=" + getMovieName() + ", getActor()=" + getActor()
				+ ", getYear()=" + getYear() + ", getCollection()=" + getCollection() + ", getSongs()=" + getSongs()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
