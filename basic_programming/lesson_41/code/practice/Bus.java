package practice;

public class Bus implements Comparable<Bus>{
    String brand;
    int capacity;
    String route;

    public Bus(String brand, int capacity, String route) {
        this.brand = brand;
        this.capacity = capacity;
        this.route = route;
    }

    public Bus() {
    }

    @Override
    public String toString() {
        return  "{route= " + route + ", brand= " + brand  + ", capacity= " + capacity + "}";
    }

    @Override
    public int compareTo(Bus o) {
        return route.compareTo(o.route);
    }
}
