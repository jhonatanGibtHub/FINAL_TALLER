package com.tallerdesarrollo.controller;

import com.tallerdesarrollo.config.ApiPaths;
import com.tallerdesarrollo.dto.UserRequest;
import com.tallerdesarrollo.dto.UserResponse;
import com.tallerdesarrollo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.USERS)
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
