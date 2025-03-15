package com.example.demo.presentation.controller;

import com.example.demo.presentation.DTO.UserDTO;
import com.example.demo.service.interfaces.IUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //FindAll
    @GetMapping("/find")
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    // Crear user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.createrUser(userDTO),HttpStatus.CREATED);
    }

    //Update User
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable Long id){

        return new ResponseEntity<>(this.userService.updateUser(userDTO,id),HttpStatus.CREATED);
    }

    //Delete User - Usuario eliminado
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }
}
