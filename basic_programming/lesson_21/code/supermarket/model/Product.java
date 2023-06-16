package model;

import java.util.Objects;

public class Product {
    private long barCode; // уникальный идентификатор (id),

    String brand; // производитель

    String type; // тип продукции, может коррелировать с barCode

    double price; // цена

    // конструктор класса
    public Product(long barCode, String brand, String type, double price) {
        this.barCode = barCode;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // если объект сравниваем сам с собой
        if (o == null || getClass() != o.getClass()) return false; // если объект не существует или из другого класса
        Product product = (Product) o; // кастим объект o до нашего класса Product
        return barCode == product.barCode; // true если совпадут или false если не совпадут
    }

    // вычисления по определенной формуле с участием числа 31
    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }

    @Override
    public String toString() {
        return "Product " +
                "barCode= " + barCode +
                ", brand=' " + brand + '\'' +
                ", type=' " + type + '\'' +
                ", price= " + price;
    }

    // пустой конструктор класса
    public Product() {
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
