package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String adress;
    private String residence;
    private String postalCode;
    private String email;
    private Integer areaCode;
    private Integer phoneNumber;

    //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */

}
