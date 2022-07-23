package org.marketplace.springwebapp.Marketplace.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @NotBlank(message = "Name and surname should be not empty!")
    @Size(min=2, max=15, message = "The name and surname should not be between 2 and 15 characters")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Name and surname should be not empty!")
    @Size(min=2, max=15, message = "The name and surname should not be between 2 and 15 characters")
    @Column(name = "surname")
    private String surname;
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Positive(message = "Amount of money should be positive")
    @Column(name = "money")
    private double money;
    @OneToMany()
    private List<Product> purchases;

    public User() {
    }

    public User(String name, String surname, int id, double money, List<Product> purchases) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
