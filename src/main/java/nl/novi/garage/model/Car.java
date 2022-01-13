package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
    private String fuel;
    private String transmission;
    private Integer year;
    private double mileage;

    //Constructor is niet nodig binnen Springboot

    //Getters and setters in code ++
    // vervallen i.v.m. toevoegen Lombok dependency
}
