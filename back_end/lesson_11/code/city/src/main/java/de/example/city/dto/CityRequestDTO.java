package de.example.city.dto;

import de.example.city.model.City;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder

@Schema(name = "NewCity", description = "Add new city")   //Swagger
public class CityRequestDTO {
    @Schema(description = "The name of the city", example = "Berlin")
    private String name;
    @Schema(description = "The country", example = "Germany")
    private String country;
    @Schema(description = "Population of the city", example = "4300000")
    private int population;

    public static City toCity(CityRequestDTO cityRequestDTO){
        return new City(null, cityRequestDTO.getName(), cityRequestDTO.getCountry(), cityRequestDTO.getPopulation());
    }
    public static List<City> toCity(List<CityRequestDTO> cityRequestDTO){
        return cityRequestDTO.stream().map( CityRequestDTO::toCity).toList();
    }
}
