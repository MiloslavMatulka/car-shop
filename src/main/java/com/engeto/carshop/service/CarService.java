package com.engeto.carshop.service;

import com.engeto.carshop.model.Car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    Car addCar(Car carToCreate);

    int deleteAll();

    Car deleteCar(Car carToDelete);

    List<Car> getAllCars();

    Car getCarById(int id);

    int getMaxId();

    int populateTable();

    void resetIds();

    Car updateCar(Car carToUpdate);
}
