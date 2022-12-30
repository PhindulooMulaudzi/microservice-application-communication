package io.javabrains.models;

public class Movie {
	private String movieId;
	private String name;
	
	
	/*
	 * Default constructor always required if we need Spring to convert atype to a partciular class object format
	 */
	public Movie() {
		
	}
	
	public Movie(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
