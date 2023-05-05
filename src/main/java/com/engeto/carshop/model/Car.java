package com.engeto.carshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private boolean isForSale;
    private String name;
    private BigDecimal price;

    public Car() {}

    public Car(String name, Boolean isForSale, BigDecimal price) {
        this.name = name;
        this.isForSale = isForSale;
        this.price = price;
    }

    public Car(int id, String name, Boolean isForSale, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.isForSale = isForSale;
        this.price = price;
    }

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    //endregion

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", isForSale=" + isForSale +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
