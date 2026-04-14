package com.example.lastminutereservation.dto;

import lombok.Data;

@Data
public class RestaurantTableRequest {
    private int seats;
    private Long restaurantId;
}
