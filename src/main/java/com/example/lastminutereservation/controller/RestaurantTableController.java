package com.example.lastminutereservation.controller;

import com.example.lastminutereservation.model.RestaurantTable;
import com.example.lastminutereservation.service.RestaurantTableService;
import com.example.lastminutereservation.dto.RestaurantTableRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public RestaurantTable getRestaurantTableById(@PathVariable Long id) {
        return restaurantTableService.getRestaurantTableById(id);
    }

    @PostMapping
    public RestaurantTable createRestaurantTable(@RequestBody RestaurantTable restaurantTable) {
        return restaurantTableService.saveRestaurantTable(restaurantTable);
    }

    @PostMapping("/bulk")
    public List<RestaurantTable> createRestaurantTables(@RequestBody List<RestaurantTableRequest> requests) {
        return restaurantTableService.saveRestaurantTables(requests);
    }
}
