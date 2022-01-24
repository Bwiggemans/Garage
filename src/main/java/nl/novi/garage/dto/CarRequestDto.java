package nl.novi.garage.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class CarRequestDto {

    //Attribute validation
    @NotBlank
    @Size(min = 1, max = 3)
    private String brand;

    @NotBlank
    @Size(min = 1, max = 12)
    private String model;

    @NotBlank
    @Size(min = 1, max = 9)
    private String fuel;

    @NotBlank
    @Size(min = 8, max = 8)
    private String licensePlate;

    @NotBlank
    @Size(min = 1, max = 9)
    private String transmission;

    @Max(2022)
    @Min(1944)  //Kia wasfounded 1944
    private Integer year;

    @Max(999999)
    @Min(1)
    private double mileage;

    //Getters and setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

}
