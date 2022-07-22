package org.marketplace.springwebapp.models;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class Product {

    @NotBlank(message = "Name should be not empty!")
    @Size(min=2, max=15, message = "The name should not be between 2 and 15 characters")
    private String name;

    private int id;
    @Positive (message = "The price should be positive")
    private BigDecimal price;  // I use BigDecimal bc double is tricky for such operations like 0.1+0.2=0.3000000000000004


    public Product(String name, int id, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
