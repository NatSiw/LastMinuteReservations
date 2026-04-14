package com.example.lastminutereservation.config;

import com.example.lastminutereservation.dto.RestaurantTableRequest;
import com.example.lastminutereservation.model.Restaurant;
import com.example.lastminutereservation.repository.RestaurantRepository;
import com.example.lastminutereservation.repository.RestaurantTableRepository;
import com.example.lastminutereservation.service.RestaurantTableService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableService restaurantTableService;

    public DataInitializer(RestaurantTableRepository restaurantTableRepository,
                          RestaurantRepository restaurantRepository,
                          RestaurantTableService restaurantTableService) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantTableService = restaurantTableService;
    }

    @Override
    public void run(String... args) {
        if (restaurantTableRepository.count() > 0) {
            System.out.println("Skipping initialization.");
            return;
        }

        System.out.println("Initializing restaurant tables...");
        
        List<Restaurant> restaurants = restaurantRepository.findAll();
        
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found. Please add restaurants first.");
            return;
        }

        List<RestaurantTableRequest> allTableRequests = new ArrayList<>();
        Random random = new Random();

        for (Restaurant restaurant : restaurants) {
            int numberOfTables = 5 + random.nextInt(8);
            
            for (int i = 0; i < numberOfTables; i++) {
                RestaurantTableRequest request = new RestaurantTableRequest();
                request.setRestaurantId(restaurant.getId());

                int[] possibleSeats = {2, 2, 4, 4, 4, 6, 6, 8};
                request.setSeats(possibleSeats[random.nextInt(possibleSeats.length)]);
                
                allTableRequests.add(request);
            }
        }

        restaurantTableService.saveRestaurantTables(allTableRequests);
        
        System.out.println("Successfully created " + allTableRequests.size() + " tables for " + restaurants.size() + " restaurants.");
    }
}
