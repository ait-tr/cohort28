package practice.bus;

import java.util.Objects;

public class Bus implements Comparable<Bus>{
    String brand;
    String route;
    int capacity;

    public Bus(String brand, String route, int capacity) {
        this.brand = brand;
        this.route = route;
        this.capacity = capacity;
    }

    public Bus(String route) {
        this.route = route;
    }

    public Bus() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "{" + "brand='" + brand + ", route='" + route + ", capacity=" + capacity + '}';
    }


    @Override
    public int compareTo(Bus o) {
        return route.compareTo(o.route); // сортируем по маршруту от меньшего к большему по алфавиту
        // 1, 1A, 20, 20B
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(route, bus.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash( route);
    }
}
