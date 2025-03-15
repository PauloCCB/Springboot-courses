package com.jpa.SpringJpaRelation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Una entidad , se refiere a una tabla
public class FootballCompetition {

    @Id // Asi se indica que es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto quiere decir que tenga un valor , auto_increment
    private Long id;
    @Column(name="name",columnDefinition = "VARCHAR(150)")
    private String name;

    @Column(name="cuantity_price")
    private Integer cuantityPrice;

    //columnDefinition: Especificamos el tipo de dato que tendrá en SQL
    @Column(name="start_date",columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name="end_date",columnDefinition = "DATE")
    private LocalDate endDate;

    //Si aca pongo el many to many, me generara 2 tablas
}
