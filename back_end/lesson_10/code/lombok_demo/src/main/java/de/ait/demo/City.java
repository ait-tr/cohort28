package de.ait.demo;

import lombok.*;

import java.util.Objects;


//@Getter
//@Setter
@RequiredArgsConstructor
@AllArgsConstructor
    //@NoArgsConstructor
@EqualsAndHashCode (exclude = {"population"})
@ToString//(of={"name","country"},includeFieldNames = false)
@Builder

//@Data
public class City {

     @Setter @Getter private  Long id;
     @Setter private  String name;
    final private String country;
    private int population;








    public static void main(String[] args) {
        City city = new City(1L,"Berlin", "Germany",4_000_000);
        City city1 = new City(1L,"Berlin", "Germany",4_500_000);
        //City city2 = new City();
        System.out.println(city);
        System.out.println(city==city1); //false
        System.out.println(city.equals(city1)); // true

        City city4 = City.builder()
                .country("Germany")
                .id(20L)
                .build();

        System.out.println(city4);

    }


}

