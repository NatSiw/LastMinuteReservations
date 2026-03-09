package com.example.lastminutereservation.repository;

import com.example.lastminutereservation.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
