package io.javabrains.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.models.CatalogItem;
import io.javabrains.models.Movie;
import io.javabrains.models.Rating;


/*
 * In this case we are mapping the endpoint to the whole class instead of just a single method
 * 
 * Notice that any endpoint at "/catalog" will result in this class being called
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;

	
	/*
	 * Here we are mapping the Rest endpoint /catalog/$userId remember the curly braces
	 * to indicate a variable path or endpoint
	 */
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		/*
		 * 1. Link the movie catalog to the movie infor service
		 * we will first hardcode the ratings just so we can see how the linking works.
		 */
		
		/* Presumed response from the RatingsAPI that we hard code with all the 
		 * movies userId has watched
		 * 
		 * 
		 */
		List<Rating> ratings = Arrays.asList(
					new Rating("1234", 4),
					new Rating("5678", 3)
		);
		
		/*
		 * We will use a RestTemplate to call the movieInfo service
		 * 
		 * The movie info needs to be called fofr every movie the user has watched
		 */
				
		List<CatalogItem> catalogItems = new ArrayList<>();
		
		for (Rating rating : ratings) {
			/*
			 * getForObjet takes in any URL String and a responseType or payload that is expected and returns an object in that form
			 * 
			 * We have created the movie class in our models that will serve this purpose
			 * 
			 * for each movieId in ratings, we need to get that movie. That will give us access to the movie info
			 */
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			catalogItems.add(new CatalogItem(movie.getName(), "Description", rating.getRating()));
			
		}
		
		return catalogItems;
	}
}
