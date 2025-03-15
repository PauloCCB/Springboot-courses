package com.jpa.SpringJpaRelation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Una entidad , se refiere a una tabla
public class Entrenador {
    @Id // Asi se indica que es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto quiere decir que tenga un valor , auto_increment
    private Long id;
    private String name;

    @Column(name="last_name")
    private String lastName;
    private String nacionality;
    private Integer age;
}
