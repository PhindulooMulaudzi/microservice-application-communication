package io.javabrains.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.models.Movie;

/*
 * In this case we are mapping the endpoint to the whole class instead of just a single method
 * 
 * Notice that any endpoint at "/movies" will result in this class being called
 */
@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	/*
	 * Here we are mapping the Rest endpoint /movies/$movieId remember the curly braces
	 * to indicate a variable path or endpoint
	 */
	
	@RequestMapping("{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId, "Test name");
	}
}
