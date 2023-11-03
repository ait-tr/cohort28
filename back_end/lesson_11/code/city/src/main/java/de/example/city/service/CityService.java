package de.example.city.service;

import de.example.city.dto.CityRequestDTO;
import de.example.city.dto.CityResponseDTO;
import de.example.city.model.City;

import java.util.List;

public interface CityService {
    List<CityResponseDTO> findAll();
    CityResponseDTO createCity(CityRequestDTO city);
    CityResponseDTO findCityById(Long id);
    List<CityResponseDTO> findByCountry(String country);
    CityResponseDTO updateCity(CityRequestDTO city, Long id);


}
