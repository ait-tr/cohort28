package model;

import java.util.Objects;

public class Food extends Product{
    private int termin; // срок хранения

    private String vendor; // поставщик

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return termin == food.termin && Objects.equals(vendor, food.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), termin, vendor);
    }

    @Override
    public String toString() {
        return "Food{" +
                "termin=" + termin +
                ", vendor='" + vendor + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    // конструктор класса
    public Food(long barCode, String brand, String type, double price, int termin, String vendor) {
        super(barCode, brand, type, price);
        this.termin = termin;
        this.vendor = vendor;
    }

    public int getTermin() {
        return termin;
    }

    public void setTermin(int termin) {
        this.termin = termin;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
