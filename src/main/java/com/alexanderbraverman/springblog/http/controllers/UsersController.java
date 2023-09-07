package com.alexanderbraverman.springblog.http.controllers;

import com.alexanderbraverman.springblog.database.DatabaseConnectionService;
import com.alexanderbraverman.springblog.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController{
    @Autowired
    private DatabaseConnectionService databaseConnectionService;
    private final IUserRepository userRepository;

    public UsersController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        boolean isConnectionValid = databaseConnectionService.isDatabaseConnectionValid();

        if (isConnectionValid) {
            System.out.println("Database connection is valid.");
        } else {
            System.out.println("Database connection is not valid.");
        }
        return ResponseEntity.ok(userRepository.findAll());
    }
}
