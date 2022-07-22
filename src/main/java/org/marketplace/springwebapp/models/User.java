package org.marketplace.springwebapp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public class User {
    @NotBlank(message = "Name and surname should be not empty!")
    @Size(min=2, max=15, message = "The name and surname should not be between 2 and 15 characters")
    private String name, surname;
    private int id;

    @Positive(message = "Amount of money should be positive")
    private BigDecimal money; // I use BigDecimal bc double is tricky for such operations like 0.1+0.2=0.3000000000000004

    private List<Product> purchases;

    public User(String name, String surname, int id, BigDecimal money, List<Product> purchases) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.money = money;
        this.purchases = null;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

}
