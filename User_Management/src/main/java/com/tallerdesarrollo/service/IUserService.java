package com.tallerdesarrollo.service;

import com.tallerdesarrollo.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserModel createUser(UserModel userModel);

    UserModel updateUser(Integer id, UserModel userModel);

    void deleteUser(Integer id);

    Optional<UserModel> getUserById(Integer id);

    List<UserModel> getAllUsers();

    UserModel authenticateUser(String username, String password);
}
