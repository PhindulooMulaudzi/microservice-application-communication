package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {
	
	/*
	 * We create a Bean for out restTemplate so that we can keep one instance of it
	 * This avoids wastage as we have a signleton for everyone
	 * Spring will ensure that everyone gets that one instance when a restTemplate is neeeded 
	 * Remember we just need to AutoWire
	 */
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
