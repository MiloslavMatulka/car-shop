package com.engeto.carshop.mapper;

import com.engeto.carshop.model.Car;
import com.engeto.carshop.model.dto.CarDTO;

import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    public CarDTO toDto(Car car) {
        return new CarDTO(car.getName(), car.getPrice());
    }
}
