package ait.product.model;

public class Food extends Product {
    private String expDate;

    public Food(double price, String name, long barCode, String expDate) {
        super(price, name, barCode);
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exp. Date: " + expDate;
    }
}
