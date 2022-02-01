package nl.novi.garage.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars_inspection_repair")
public class CarInspectionRepair {

    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean inspection;
    private boolean repair;
    private boolean consentCustomer;
    private boolean repairCompleted;

    @ManyToOne
    private Car car;

    @OneToMany(mappedBy = "carInspectionRepair")
    @JsonIgnore
    private List<CarInspectionRepairShop> carInspectionRepairShop = new ArrayList<>();

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInspection() {
        return inspection;
    }

    public void setInspection(boolean inspection) {
        this.inspection = inspection;
    }

    public boolean isRepair() {
        return repair;
    }

    public void setRepair(boolean repair) {
        this.repair = repair;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isConsentCustomer() {
        return consentCustomer;
    }

    public void setConsentCustomer(boolean consentCustomer) {
        this.consentCustomer = consentCustomer;
    }

    public boolean isRepairCompleted() {
        return repairCompleted;
    }

    public void setRepairCompleted(boolean repairCompleted) {
        this.repairCompleted = repairCompleted;
    }

    public List<CarInspectionRepairShop> getCarInspectionRepairShop() {
        return carInspectionRepairShop;
    }

    public void setCarInspectionRepairShop(List<CarInspectionRepairShop> carInspectionRepairShop) {
        this.carInspectionRepairShop = carInspectionRepairShop;
    }
}
