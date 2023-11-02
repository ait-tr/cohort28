package de.example.city.service;

import de.example.city.model.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City createCity(City city);
    City findCityById(Long id);
}
