package exchanger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Truck implements Runnable{

    private int truckNumber;
    private String startPoint;
    private String endPoint;
    private List<String> goods;

 //   private List<String> newGoods;
    private Exchanger<List<String>> exchanger;

    public Truck(int truckNumber, String startPoint, String endPoint, List<String> goods, Exchanger<List<String>> exchanger) {
        this.truckNumber = truckNumber;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.goods = goods;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        System.out.println("Truck " + truckNumber + " is loading with goods: " + goods);
        System.out.println("Truck " + truckNumber + " start from " + startPoint + " to " + endPoint);

        try {
            //эмуляция процесса перевозки товара
            Thread.sleep(new Random().nextInt(4000) + 2000);

            //грузовик достиг точки обмена и производит обмен товаром
            System.out.println("Truck " + truckNumber + " arrived at point E for goods exchange");

            goods = exchanger.exchange(goods);

            System.out.println("Truck " + truckNumber + " exchanged goods at point E. Received goods: " + goods);

            Thread.sleep(new Random().nextInt(2000) + 1000);

            System.out.println("Truck " + truckNumber + " arrived at point " + endPoint + "and delivers goods: " + goods);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }



    }
}
