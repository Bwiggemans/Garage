package nl.novi.garage.model;


import javax.persistence.*;

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
    private Double price;
    private Integer stock;

    //Constructor
    public SparePart() {
    }

    public SparePart(String brand, String part, String partNumber, Double price, Integer stock) {
        this.brand = brand;
        this.part = part;
        this.partNumber = partNumber;
        this.price = price;
        this.stock = stock;
    }

    //Constructor
    public SparePart(int id, String brand, String part, String partNumber, Double price, Integer stock) {
        this.id = id;
        this.brand = brand;
        this.part = part;
        this.partNumber = partNumber;
        this.price = price;
        this.stock = stock;
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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
