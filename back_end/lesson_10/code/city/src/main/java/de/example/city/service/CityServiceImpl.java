package de.example.city.service;

import de.example.city.model.City;
import de.example.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City createCity(City city) {
        return repository.save(city);
    }

    @Override
    public City findCityById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
