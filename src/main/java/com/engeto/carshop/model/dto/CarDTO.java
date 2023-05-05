package com.engeto.carshop.model.dto;

import java.math.BigDecimal;

/**
 * DTO class is used in case not all details of the model should be disclosed.
 */
public class CarDTO {

    private String name;
    private BigDecimal price;

    public CarDTO() {
    }

    public CarDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
