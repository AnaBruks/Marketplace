package org.marketplace.springwebapp.models;

import jakarta.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @NotBlank(message = "Name should be not empty!")
    @Size(min=2, max=15, message = "The name should not be between 2 and 15 characters")
    @Column(name = "name")
    private String name;
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Positive (message = "The price should be positive")
    @Column(name = "price")
    private double price;


    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
