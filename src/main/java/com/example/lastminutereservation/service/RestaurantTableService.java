package com.example.lastminutereservation.service;

import com.example.lastminutereservation.model.Restaurant;
import com.example.lastminutereservation.model.RestaurantTable;
import com.example.lastminutereservation.dto.RestaurantTableRequest;
import com.example.lastminutereservation.repository.RestaurantRepository;
import com.example.lastminutereservation.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantRepository restaurantRepository;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository, RestaurantRepository restaurantRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantRepository = restaurantRepository;
    }

    //get all tables
    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableRepository.findAll();
    }

    //get table by id
    public RestaurantTable getRestaurantTableById(Long id) {
        return restaurantTableRepository.findById(id).orElse(null);
    }

    //save table from object
    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    //save table from dto
    public RestaurantTable saveRestaurantTable(RestaurantTableRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + request.getRestaurantId()));

        RestaurantTable table = RestaurantTable.builder()
                .seats(request.getSeats())
                .restaurant(restaurant)
                .build();

        return restaurantTableRepository.save(table);
    }

    //save tables from dto
    public List<RestaurantTable> saveRestaurantTables(List<RestaurantTableRequest> requests) {
        List<RestaurantTable> tables = requests.stream()
                .map(request -> {
                    Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                            .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + request.getRestaurantId()));
                    return RestaurantTable.builder()
                            .seats(request.getSeats())
                            .restaurant(restaurant)
                            .build();
                })
                .toList();

        return restaurantTableRepository.saveAll(tables);
    }

}
