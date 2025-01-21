package com.tallerdesarrollo.controller;

import com.tallerdesarrollo.dto.UserRequest;
import com.tallerdesarrollo.model.UserModel;
import com.tallerdesarrollo.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public UserModel createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Integer id, @Valid @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
