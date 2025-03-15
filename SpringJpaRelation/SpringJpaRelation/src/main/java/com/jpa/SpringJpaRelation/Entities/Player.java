package com.jpa.SpringJpaRelation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Una entidad , se refiere a una tabla
public class Player {
    @Id // Asi se indica que es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto quiere decir que tenga un valor , auto_increment
    private Long id;
    private String name;

    @Column(name="last_name")
    private String lastName;
    private String nacionality;
    private Integer age;
    private String position;

    /* Recuerda que aqui tengo que poner el id del club asociado al player*/
    /* Relación de uno a muchos*/
    // Este player seria uno o muchos ? Sino muchos, por eso se pone el many
    @ManyToOne(targetEntity = Club.class)
    private Club club;
}
