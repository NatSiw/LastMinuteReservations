package com.example.lastminutereservation.controller;
import com.example.lastminutereservation.model.Restaurant;
import com.example.lastminutereservation.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    @PostMapping("/bulk")
    public List<Restaurant> createRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.saveRestaurants(restaurants);
    }
}
