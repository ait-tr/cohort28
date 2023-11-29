package setCollection;

import java.util.Objects;

public class Town {

    private String country;
    private String town;

    public Town(String country, String town) {
        this.country = country;
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town1 = (Town) o;
        return Objects.equals(country, town1.country) && Objects.equals(town, town1.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Town{" +
                "country='" + country + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
