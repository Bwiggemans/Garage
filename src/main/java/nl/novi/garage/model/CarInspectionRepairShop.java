package nl.novi.garage.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars_repair_inspection_shop")
public class CarInspectionRepairShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private LocalDateTime dateCarInspectionRepairOn;
    private LocalDateTime dateCarInspectionRepairFinish;


    @ManyToOne
    @JsonManagedReference
    private CarInspectionRepair carInspectionRepair;

    @ManyToOne
    private Customer customer;

}
