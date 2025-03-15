package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
//Una entidad no es un DAO o un DTO
public class UserEntity {
    // Un entity es una representacion de clase objeto,
    // representa un tabla de la base de datos
    //es un objeto que representa algo real o conceptual de tu aplicación.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="last_name")
    private String lastname;
    private String email;
    private byte age;

}
