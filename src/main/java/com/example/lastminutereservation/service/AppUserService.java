package com.example.lastminutereservation.service;
import com.example.lastminutereservation.model.AppUser;
import com.example.lastminutereservation.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
