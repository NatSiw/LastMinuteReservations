package com.example.lastminutereservation.repository;

import com.example.lastminutereservation.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
