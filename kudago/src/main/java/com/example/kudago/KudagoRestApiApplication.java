package com.example.kudago;

import com.example.kudago.model.Category;
import com.example.kudago.model.Location;
import com.example.kudago.service.CategoryService;
import com.example.kudago.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KudagoRestApiApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private LocationService locationService;
	public static void main(String[] args) {
		SpringApplication.run(KudagoRestApiApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String categoryUrl = "https://kudago.com/public-api/v1.4/place-categories";
		Category[]  categories = restTemplate.getForObject(categoryUrl, Category[].class);
		for (Category category : categories) {
			categoryService.addCategory(category);
		}

		String locationUrl = "https://kudago.com/public-api/v1.4/locations";
		Location[] locations = restTemplate.getForObject(locationUrl, Location[].class);
		for (Location location : locations) {
			locationService.addLocation(location);
		}
	}

}