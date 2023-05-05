package com.engeto.carshop.controller;

import com.engeto.carshop.mapper.CarMapper;
import com.engeto.carshop.model.Car;
import com.engeto.carshop.model.dto.CarDTO;
import com.engeto.carshop.service.CarServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarMapper carMapper;

    @Autowired
    CarServiceImpl carService;
    Logger logger = LoggerFactory.getLogger(CarController.class);

    @Value("${com.engeto.author}")
    private String nameOfAuthor;

    @PostMapping(value = "/add-car")
    public Car addCar(@RequestBody Car carToCreate) {
        carService.addCar(carToCreate);
        logger.info("Creating " + carToCreate.toString());
        return carToCreate;
    }

    @DeleteMapping(value = "/delete-all")
    public int deleteCar() {
        int count = carService.deleteAll();
        logger.info(String.format("Deleting %s cars", count));
        return count;
    }

    @DeleteMapping(value = "/delete-car")
    public Car deleteCar(@RequestBody Car carToDelete) {
        logger.info(String.format("Deleting %s", carToDelete.toString()));
        carService.deleteCar(carToDelete);
        return carToDelete;
    }

    @GetMapping(value = "/get-all-cars")
    public List<Car> getAllCars() {
        logger.info("Getting all cars");
        return carService.getAllCars();
    }

    @GetMapping(value = "/get-car-by-id/{id}")
    public CarDTO getCarById(@PathVariable int id) {
        Car carById = carService.getCarById(id);
        logger.info("Getting mapped car DTO by ID, " + carById.toString());
        return carMapper.toDto(carById);
    }

    @GetMapping(value = "/get-max-id")
    public int getMaxId() {
        int maxId = carService.getMaxId();
        logger.info("Getting max ID = " + maxId);
        return maxId;
    }

    @PostMapping(value = "/populate-table")
    public int populateTable() {
        int count = carService.populateTable();
        logger.info(String
                .format("Populating table, %s cars inserted", count));
        return count;
    }

    @DeleteMapping(value = "/reset-ids")
    public String resetIds() {
        logger.info("Resetting Ids");
        carService.resetIds();
        return "IDs reset";
    }

    @PutMapping(value = "/update-car")
    public Car updateCar(@RequestBody Car carToUpdate) {
        carService.updateCar(carToUpdate);
        logger.info("Updating to " + carToUpdate.toString());
        return carToUpdate;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception e) {
        return new ErrorResponse(e.getLocalizedMessage(),
                nameOfAuthor, LocalDateTime.now(), e.getStackTrace());
    }
}
