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
public class Club {

    @Id // Asi se indica que es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto quiere decir que tenga un valor , auto_increment
    private Long id;

    private String name;

    /* Relación de uno a uno*/
    //Esto debe ir en donde va a quedar la llave foranea (el One to ONE)
    //Propiedades adicionales
    // TargetEntity= Con esto le indico cual será la entidad se hará la relacion
    // Cascade : Comportamiento en cascada
    // PERSIST.- Si yo creo un regristro de Club , se asocia el coach
    // REMOVE - Si yo elimino el Club , inmediatamente se eliminará el Coach
    // MERGE : Si yo actualizo el club , se actualiza  el coach
    //fetch : Se utiliza con listas
    //Personalizar el nombre de la columna de la llave foranea con el joinColumn
    @JoinColumn(name="id_entrenador")
    @OneToOne (targetEntity = Entrenador.class,cascade = CascadeType.PERSIST)
    private Entrenador entrenador;


    /* Relación de uno a muchos*/
    // Aca se pone cuando son muchos jugadores de forma de lista
    // Aqui se manifiesta la relacion de muchos
    // La entidad que estamos , es Club es uno o muchos con respecto a player?
    // Fetch, para que me sirve? . Para traer los datos, sin embargo el
    // LAZY me indica que cuando yo cargue un club , me va a obtener la plantilla de jugadores
    // Solamente cuando yo se lo solicite, sin embargo
    // EAGER, cuando yo instancia o llame a la instacia de Club, se va a cargar todos los jugadores
    // y lo guarda en memoria.

    //* Mappedby: El mapedby le estamso diciendo que esta relacion se tiene que mapear con cierto atributo
    // cierto objeto indicado
    // es decir el otro atributo es la llave foranea, se pone el nombre del objeto*/

    @OneToMany(targetEntity = Player.class,fetch =FetchType.LAZY,mappedBy = "club")
    private List<Player> players;

    @ManyToOne(targetEntity = FootballAsociation.class)
    private FootballAsociation footballAsociation;

    @ManyToMany(targetEntity = FootballCompetition.class,fetch = FetchType.LAZY)
    //JoinColumnas me permitará modificar las columnas de los id,
    // Con el inverseJoinColumn, le indicamos a la relación inversa ponerle un atributo
    @JoinTable(name="club_competitions",joinColumns =@JoinColumn(name="club"),inverseJoinColumns = @JoinColumn(name="competition"))
    private List <FootballCompetition> footballCompetitions;
}
