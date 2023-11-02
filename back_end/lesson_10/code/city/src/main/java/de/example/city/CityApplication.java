package de.example.city;

import de.example.city.model.City;
import de.example.city.repository.CityRepository;
import de.example.city.repository.CityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);

    }

}
