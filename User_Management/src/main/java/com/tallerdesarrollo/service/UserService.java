package com.tallerdesarrollo.service;

import com.tallerdesarrollo.dto.UserRequest;
import com.tallerdesarrollo.dto.UserResponse;
import com.tallerdesarrollo.exception.CustomException;
import com.tallerdesarrollo.model.UserModel;
import com.tallerdesarrollo.repository.UserRepository;
import com.tallerdesarrollo.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        try {
            UserModel user = new UserModel();
            // Set fields from request to user...
            user = userRepository.save(user);
            return mapToResponse(user);
        } catch (Exception e) {
            LoggerUtil.error("Error creating user: " + e.getMessage());
            throw new CustomException("Error creating user");
        }
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private UserResponse mapToResponse(UserModel user) {
        UserResponse response = new UserResponse();
        // Map fields...
        return response;
    }
}
