package com.tallerdesarrollo.service;

import com.tallerdesarrollo.dto.UserRequest;
import com.tallerdesarrollo.model.UserModel;
import com.tallerdesarrollo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel createUser(UserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setNombre(userRequest.getNombre());
        userModel.setApellidoPaterno(userRequest.getApellidoPaterno());
        userModel.setApellidoMaterno(userRequest.getApellidoMaterno());
        userModel.setSexo(userRequest.getSexo());
        userModel.setFechaNacimiento(userRequest.getFechaNacimiento());
        userModel.setCelular(userRequest.getCelular());
        userModel.setUsername(userRequest.getUsername());
        userModel.setPassword(userRequest.getPassword());
        userModel.setEstado(userRequest.getEstado());
        userModel.setCodigoVendedor(userRequest.getCodigoVendedor());

        return userRepository.save(userModel);
    }

    @Override
    public UserModel updateUser(Integer id, UserRequest userRequest) {
        UserModel userModel = userRepository.findById(id).orElseThrow();
        userModel.setNombre(userRequest.getNombre());
        userModel.setApellidoPaterno(userRequest.getApellidoPaterno());
        userModel.setApellidoMaterno(userRequest.getApellidoMaterno());
        userModel.setSexo(userRequest.getSexo());
        userModel.setFechaNacimiento(userRequest.getFechaNacimiento());
        userModel.setCelular(userRequest.getCelular());
        userModel.setUsername(userRequest.getUsername());
        userModel.setPassword(userRequest.getPassword());
        userModel.setEstado(userRequest.getEstado());
        userModel.setCodigoVendedor(userRequest.getCodigoVendedor());

        return userRepository.save(userModel);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }
}
