package de.example.city.contoller;

import de.example.city.dto.CityRequestDTO;
import de.example.city.dto.CityResponseDTO;
import de.example.city.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@Tag(name = "Cities API", description = "Operations for managing cities")    // swagger
public class CityController {
    @Autowired
    private CityService service;
    // localhost:8080/cities/countries/{id}
    // localhost:8080/cities?country=Germany



    // localhost:8080/cities   -> @GetMapping
    // localhost:8080/cities/{id}  -> @GetMapping("/{id}")
    // localhost:8080/accounts/  -> no way
    /*
    @GetMapping   // GET localhost:8080/cities
    //@RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<CityResponseDTO> getCities(){
        return service.findAll();
    }

     */

    @PostMapping

    @Operation(description = "Crete new city")
    public CityResponseDTO createCity(@RequestBody CityRequestDTO city){
        return service.createCity(city);
    }

    // localhost:8080/cities
    // localhost:8080/cities?country=Germany
    @Operation(description = "get all cities or get cities by country")
    @Parameter(name = "country", description = "filter by country", in = ParameterIn.QUERY, required = false,example = "Germany")
    @GetMapping
    public  List<CityResponseDTO> getCities(
            @RequestParam(name="country", required = false, defaultValue = "all") String country){
        return country.equals("all")?service.findAll():service.findByCountry(country);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update city", description = "update city with given id")
    public CityResponseDTO updateCity(@RequestBody CityRequestDTO city, @PathVariable Long id){
        return service.updateCity(city,id);
    }
}
