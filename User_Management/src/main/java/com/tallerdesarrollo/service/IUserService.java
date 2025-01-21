package com.tallerdesarrollo.service;

import com.tallerdesarrollo.dto.UserRequest;
import com.tallerdesarrollo.model.UserModel;

import java.util.List;

public interface IUserService {
    UserModel createUser(UserRequest userRequest);
    UserModel updateUser(Integer id, UserRequest userRequest);
    void deleteUser(Integer id);
    List<UserModel> getUsers();
    UserModel getUserById(Integer id);
}
