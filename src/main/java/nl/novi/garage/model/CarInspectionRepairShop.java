package nl.novi.garage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
//    @JsonIgnore
    private CarInspectionRepair carInspectionRepair;

//    @ManyToOne
//    private Customer customer;

    @ManyToOne
    private SparePart sparePart;

    //Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateCarInspectionRepairOn() {
        return dateCarInspectionRepairOn;
    }

    public void setDateCarInspectionRepairOn(LocalDateTime dateCarInspectionRepairOn) {
        this.dateCarInspectionRepairOn = dateCarInspectionRepairOn;
    }

    public LocalDateTime getDateCarInspectionRepairFinish() {
        return dateCarInspectionRepairFinish;
    }

    public void setDateCarInspectionRepairFinish(LocalDateTime dateCarInspectionRepairFinish) {
        this.dateCarInspectionRepairFinish = dateCarInspectionRepairFinish;
    }

    public CarInspectionRepair getCarInspectionRepair() {
        return carInspectionRepair;
    }

    public void setCarInspectionRepair(CarInspectionRepair carInspectionRepair) {
        this.carInspectionRepair = carInspectionRepair;
    }

//    public Customer getCustomer() {
//        return customer;
//    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }
}
