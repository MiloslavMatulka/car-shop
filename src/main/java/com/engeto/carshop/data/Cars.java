package com.engeto.carshop.data;

import com.engeto.carshop.model.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {
        cars.add(new Car("Honda Acord", true, new BigDecimal(540000)));
        cars.add(new Car("Skoda Octavia", true, new BigDecimal(750000)));
        cars.add(new Car("Dacia Duster", false, new BigDecimal(320000)));
        cars.add(new Car("Volkswagen Passat", true, new BigDecimal(820000)));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
