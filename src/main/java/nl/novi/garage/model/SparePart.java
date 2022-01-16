package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "spareparts")

public class SparePart {

    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String part;
    private String partNumber;
    private double price;
    private Integer stock;

    //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */

}
