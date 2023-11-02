package de.example.city.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder           // use: City.builder().country("USA").name("Moscow").population(10000).build();
@ToString          //(of = {"name","country"},includeFieldNames = false)
@EqualsAndHashCode //(exclude = {"population"})
public class City {
    private Long id;
    private String name;
    private String country;
    private int population;
}






