package com.example.lastminutereservation.controller;

import com.example.lastminutereservation.model.AppUser;
import com.example.lastminutereservation.model.Restaurant;
import com.example.lastminutereservation.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @PostMapping
    public AppUser createAppuser(@RequestBody AppUser appUser) {
        return appUserService.saveAppUser(appUser);
    }
}
