package com.engeto.carshop.repository;

import com.engeto.carshop.data.Cars;
import com.engeto.carshop.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String TABLE = "car";

    public Car addNewCar(Car carToCreate) {
        jdbcTemplate.execute("INSERT INTO " + TABLE
                + " (name, is_for_sale, price) VALUES ('"
                + carToCreate.getName() + "', "
                + carToCreate.getForSale() + ", "
                + carToCreate.getPrice() + ");");
        carToCreate.setId(getMaxId());
        return carToCreate;
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM " + TABLE + ";");
    }
    public Car deleteCar(Car carToDelete) {
        jdbcTemplate.update("DELETE FROM " + TABLE + " WHERE id = "
                + carToDelete.getId());
        return carToDelete;
    }

    public List<Car> getAllCars() {
        return jdbcTemplate.query("SELECT * FROM " + TABLE + ";",
                (rs, rowNum) -> {return new Car(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("is_for_sale"),
                        rs.getBigDecimal("price")
                );
        });
    }

    public Car getCarById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM " + TABLE
                + " WHERE id = " + id + ";", (rs, rowNum) -> {
            return new Car(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("is_for_sale"),
                    rs.getBigDecimal("price")
            );
        });
    }

    public int getMaxId() {
        Integer maxId = jdbcTemplate.queryForObject("SELECT MAX(ID) FROM "
                + TABLE + ";", Integer.class);
        return (maxId != null ? maxId : 0);
    }

    public int populateTable() {
        // Load testing data
        Cars cars = new Cars();

        cars.getCars().forEach(car ->
                jdbcTemplate.update("INSERT INTO " + TABLE + " (name, "
                        + "is_for_sale, price) VALUES ('" + car.getName()
                        + "', " + car.getForSale() + ", " + car.getPrice()
                        + ");"));

        return cars.getCars().size();
    }

    /**
     * Restarts IDs. Requires ALTER user permissions.
     */
    public void resetIds() {
        jdbcTemplate.execute("ALTER TABLE " + TABLE
                + " AUTO_INCREMENT = 1;");
    }

    public Car updateCar(Car carToUpdate) {
        jdbcTemplate.execute("UPDATE " + TABLE + " SET "
                + "name = '" + carToUpdate.getName() + "', "
                + "is_for_sale = " + carToUpdate.getForSale() + ", "
                + "price = " + carToUpdate.getPrice() + " WHERE "
                + "id = " + carToUpdate.getId() + ";");
        return carToUpdate;
    }
}
