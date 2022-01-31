package nl.novi.garage.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    private Car car;

    @OneToMany(mappedBy = "carInspectionRepair")
    @JsonBackReference
    private List<CarInspectionRepairShop> carInspectionRepairShop = new ArrayList<>();

    //Gettersand setters

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

    public List<CarInspectionRepairShop> getCarInspectionRepairShop() {
        return carInspectionRepairShop;
    }

    public void setCarInspectionRepairShop(List<CarInspectionRepairShop> carInspectionRepairShop) {
        this.carInspectionRepairShop = carInspectionRepairShop;
    }
}
