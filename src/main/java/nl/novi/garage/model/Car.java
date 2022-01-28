package nl.novi.garage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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

    @JsonIgnoreProperties("cars")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer owner;

    //Constructor
    public Car() {
    }

    public Car(String brand, String model, String fuel, String licensePlate, String transmission, Integer year, double mileage, Customer owner) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.licensePlate = licensePlate;
        this.transmission = transmission;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
    }

    //constructor
    public Car(int id, String brand, String model, String fuel, String licensePlate, String transmission, Integer year, double mileage, Customer owner) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.licensePlate = licensePlate;
        this.transmission = transmission;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

}
