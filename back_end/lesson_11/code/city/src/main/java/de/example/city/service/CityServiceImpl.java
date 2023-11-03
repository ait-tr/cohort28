package de.example.city.service;

import de.example.city.dto.CityRequestDTO;
import de.example.city.dto.CityResponseDTO;
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
    public List<CityResponseDTO> findAll() {
        List<City> cities = repository.findAll();
        return CityResponseDTO.from(cities);
    }

    @Override
    public CityResponseDTO createCity(CityRequestDTO cityRequestDTO) {
        City sevedCity = repository.save(CityRequestDTO.toCity(cityRequestDTO));
        return CityResponseDTO.from(sevedCity);
    }

    @Override
    public CityResponseDTO findCityById(Long id) {
        City city = repository.findById(id).orElse(null);
        return CityResponseDTO.from(city);
    }

    @Override
    public List<CityResponseDTO> findByCountry(String country) {
        List<City> list = repository.findAll().stream().filter(city -> city.getCountry().equals(country)).toList();
        return CityResponseDTO.from(list);
    }

    @Override
    public CityResponseDTO updateCity(CityRequestDTO requestDTO, Long id) {
        City city = CityRequestDTO.toCity(requestDTO);
        city.setId(id);
        return CityResponseDTO.from(repository.save(city));
    }
}
