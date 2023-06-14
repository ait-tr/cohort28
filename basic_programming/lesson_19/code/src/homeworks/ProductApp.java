package ait.product;

import ait.product.model.Food;
import ait.product.model.MeatFood;
import ait.product.model.MilkFood;
import ait.product.model.Product;

public class ProductApp {
    public static void main(String[] args) {
        Product[] kiosk = new Product[4];
        kiosk[0] = new Product(50, "Gift card", 1000);
        kiosk[1] = new MeatFood(70, "Sosages Mizra", 2000, "31.07.2023", "beef");
        kiosk[2] = new MilkFood(95, "Goat cheese", 3000, "25.08.2023", "goat", 40);
        kiosk[3] = new Food(20, "Coca Cola", 4000, "30.07.2023");
        System.out.println("====== All products ======");
        printProducts(kiosk);
        printNonFood(kiosk);
        System.out.println("====== Stats ======");
        double res = totalPrice(kiosk);
        System.out.println("Sum of prices = " + res);
        System.out.println("====== Search ======");
        Product product = findProductByBarCode(kiosk, 2000);
        System.out.println(product);
        product = findProductByBarCode(kiosk, 5000);
        System.out.println(product);
    }

    public static double totalPrice(Product[] products) {
        double res = 0;
        for (int i = 0; i < products.length; i++) {
            res += products[i].getPrice(); //res = res + products[i].getPrice();
        }
        return res;
    }

    public static void printProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public static void printNonFood(Product[] products) {
        System.out.println("===== Not a foods =====");
        for (int i = 0; i < products.length; i++) {
            if (!(products[i] instanceof Food)) {
                System.out.println(products[i]);
            }
        }
    }

    public static Product findProductByBarCode(Product[] products, long barCode) {
        Product res = null;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getBarCode() == barCode) {
                res = products[i];
                break;
            }
        }
        return res;
    }

}
