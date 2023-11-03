package de.example.city.repository;

import de.example.city.model.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CityRepositoryImpl implements CityRepository{
    private List<City> cities = new ArrayList<>();
    {
        List<City> data = List.of(
                new City(null, "Berlin", "Germany", 3_600_000)
                , new City(null, "Rom", "Italy", 4_000_000)
                , new City(null, "New York", "USA", 8_300_000)
                , new City(null, "London", "UK", 8_900_000)
                , new City(null, "Paris", "France", 2_500_000)
                , new City(null, "Tokyo", "Japan", 15_300_000)
                , new City(null, "Hamburg", "Germany", 2_000_000)
                , new City(null, "Munich", "Germany", 1_500_000)
        );
        data.forEach((this::save));

    }


    @Override
    public List<City> findAll() {
        return new ArrayList<>(cities);
    }

    @Override
    public City save(City city) {
        if (city.getId()==null){
            city.setId(Long.valueOf(cities.size()+1));
            cities.add(city);
        } else {
            int index= city.getId().intValue()-1;
            cities.set(index,city);
        }

        return city;
    }

    @Override
    public Optional<City> findById(Long id) {
        return cities
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        cities.removeIf(c->c.getId().equals(id));
    }

    @Override
    public long count() {
        return cities.size();
    }
}
