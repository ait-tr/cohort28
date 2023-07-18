package comparator;

// класс про самолеты

import java.util.Objects;

public class Plain implements Comparable<Plain>{
    // поля
    private String manufacter;
    private String bortNumber;

    private int capacity;

    private double speed;

    // методы
    // конструктор
    public Plain(String manufacter, String bortNumber, int capacity, double speed) {
        this.manufacter = manufacter;
        this.bortNumber = bortNumber;
        this.capacity = capacity;
        this.speed = speed;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    public String getBortNumber() {
        return bortNumber;
    }

    public void setBortNumber(String bortNumber) {
        this.bortNumber = bortNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0){
            System.out.println("Capacity should be positive number.");
            return; // выходим из метода
        }
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plain plain = (Plain) o;
        return Objects.equals(bortNumber, plain.bortNumber); // строки сравниваем через equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(bortNumber);
    }

    @Override
    public int compareTo(Plain o) {
        return bortNumber.compareTo(o.bortNumber);
    }

    @Override
    public String toString() {
        return "Plain : manufacter='" + manufacter + ", bortNumber='" + bortNumber + ", capacity=" + capacity + ", speed=" + speed ;
    }
}
