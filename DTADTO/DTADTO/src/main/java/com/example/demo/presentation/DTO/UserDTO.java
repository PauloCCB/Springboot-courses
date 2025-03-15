package com.example.demo.presentation.DTO;


import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private byte age;
}
