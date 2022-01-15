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
    private String licensePlate;
    private String transmission;
    private Integer year;
    private double mileage;

    //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */
}
