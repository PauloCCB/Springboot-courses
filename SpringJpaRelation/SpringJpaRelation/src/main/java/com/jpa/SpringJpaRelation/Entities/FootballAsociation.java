package com.jpa.SpringJpaRelation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Una entidad , se refiere a una tabla
public class FootballAsociation {
    @Id // Asi se indica que es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto quiere decir que tenga un valor , auto_increment
    private Long id;
    private String name;
    private String country;
    private String president;

    // Aca ponemos el nombre del atributo que se va asociar , que se encuentra en clubs.
    @OneToMany(targetEntity = Club.class,fetch = FetchType.LAZY,mappedBy = "footballAsociation")
    private List<Club> clubs;

}
