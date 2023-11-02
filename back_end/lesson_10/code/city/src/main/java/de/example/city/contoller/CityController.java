package de.example.city.contoller;

import de.example.city.model.City;
import de.example.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService service;

    // localhost:8080/cities   -> @GetMapping
    // localhost:8080/cities/{id}  -> @GetMapping("/{id}")
    // localhost:8080/accounts/  -> no way
    @GetMapping   // GET localhost:8080/cities
    //@RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCities(){
        return service.findAll();
    }

    @PostMapping
    public City createCity( @RequestBody City city){
        return service.createCity(city);
    }





}
