package com.engeto.carshop.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DataSourceConfig {

    @Bean
    public static DataSource source() {
        DataSourceBuilder<?> db = DataSourceBuilder.create();

        db.driverClassName("com.mysql.cj.jdbc.Driver");
        db.url("jdbc:mysql://localhost:3306/carshop");
        db.username("mysql.carshop");
        db.password("carshop");

        return db.build();
    }
}
