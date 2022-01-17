package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //Make relation oneToMany with list of cars
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customers_id", referencedColumnName = "id")
    private List<Car> cars = new ArrayList<>();

    //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */

}
