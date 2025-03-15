package com.example.demo.service.interfaces;

import com.example.demo.presentation.DTO.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findById (Long id);
    UserDTO createrUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO,Long id);
    String deleteUser(Long id);
}
