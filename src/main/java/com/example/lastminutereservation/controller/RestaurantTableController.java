package com.example.lastminutereservation.controller;

import com.example.lastminutereservation.model.RestaurantTable;
import com.example.lastminutereservation.service.RestaurantTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {
    private final RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @GetMapping
    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableService.getAllRestaurantTables();
    }
}
