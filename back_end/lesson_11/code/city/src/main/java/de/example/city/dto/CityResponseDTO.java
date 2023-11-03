package de.example.city.dto;


import de.example.city.model.City;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CityResponseDTO {

    private Long id;
    @Schema(description = "The name of the city", example = "Berlin")
    private String name;
    @Schema(description = "The country", example = "Germany")
    private String country;
    @Schema(description = "Population of the city", example = "4300000")
    private int population;
    @Schema(description = "The example string")
    private String str;

    public static CityResponseDTO from(City city){
        return new CityResponseDTO(city.getId(),
                city.getName(),
                city.getCountry(),
                city.getPopulation(),"message for user of our service");
    }

    public static List<CityResponseDTO> from(List<City> cities){
        return cities.stream().map(CityResponseDTO::from).toList();
    }
}

