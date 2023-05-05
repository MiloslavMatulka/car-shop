package com.engeto.carshop.service;

import com.engeto.carshop.model.Car;
import com.engeto.carshop.repository.CarRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    CarRepository carRepo;

    public CarServiceImpl(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public Car addCar(Car carToCreate) {
        carRepo.addNewCar(carToCreate);
        return carToCreate;
    }

    @Override
    public int deleteAll() {
        return carRepo.deleteAll();
    }

    @Override
    public Car deleteCar(Car carToDelete) {
        return carRepo.deleteCar(carToDelete);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepo.getAllCars();
    }

    @Override
    public Car getCarById(int id) {
        return carRepo.getCarById(id);
    }

    @Override
    public int getMaxId() {
        return carRepo.getMaxId();
    }

    @Override
    public int populateTable() {
        return carRepo.populateTable();
    }

    @Override
    public void resetIds() {
        carRepo.resetIds();
    }

    @Override
    public Car updateCar(Car carToUpdate) {
        carRepo.updateCar(carToUpdate);
        return carToUpdate;
    }
}
