package ait.product.model;

public class Product {
    private double price;
    private String name;
    private long barCode;

    public Product(double price, String name, long barCode) {
        this.price = price;
        this.name = name;
        this.barCode = barCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Product)){
            return false;
        }
        Product other = (Product) obj;
        return barCode == other.barCode;
    }
}
