package autopark;

import java.util.ArrayList;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Bus {

    private static final int PASSENGERS_MAX_COUNT = 5;

    private String number;

    private Driver driver; // водитель

    private boolean isGoing; // true - если автобус едет, false - если автобус стоит
    private ArrayList<Passenger> passengers; // список пассажиров

    public Bus(String number) {
        this.setNumber(number);
        this.passengers = new ArrayList<>(); // создали пустой список
    }

    /**
     * Метод, который позволяет автобусу положить водителя
     * Метод проверяет, чтобы водитель не был null, и при этом метод освобождает предыдущего водителя, если он был
     *
     * @param driver новый водитель
     */
    void setDriver(Driver driver) {
        if (isGoing) { // если автобус едет - менять водителя нельзя
            System.err.println("На ходу водителя не меняют");
            return;
        }
        if (driver != null) { // проверяем, а не null-ли новый водитель
            if (this.driver != null) { // проверим, а не было ли предыдущего водителя
                System.out.println("Освобождаем " + this.driver.getFirstName());
                this.driver.free(); // если он был - освобождаем его от работы
            }
            System.out.println("Водителем автобуса <" + number + "> стал " + driver.getFirstName());
            this.driver = driver; // назначаем нового водителя
        } else { // если новый водитель - null
            // сообщаем об ошибке - нельзя класть null водителя
            throw new IllegalArgumentException("Нельзя положить null-водителя");
        }
    }

    /**
     * Метод, который позволяет ехать автобусу
     */
    void go() {
        if (this.isGoing) {
            // если автобус уже едет - не можем поехать еще раз
            System.err.println("Автобус уже едет");
            return; // останавливаем работу метода go, все, что дальше в этом методе - выполняться не будет
        }
        if (this.driver == null) {
            System.err.println("У автобуса нет водителя, поехать не можем");
        } else {
            System.out.println("Автобус под управлением " + driver.getFirstName() + " поехал");
            this.isGoing = true;
            // пробегаем по всем пассажирам
            for (Passenger passenger : passengers) { // просим рассказать о текущей ситуации
                passenger.sayAbout();
            }
        }
    }

    /**
     * Останавливает автобус
     */
    void stop() {
        System.out.println("Автобус <" + number + "> остановился");
        isGoing = false;
    }

    /**
     * Добавляет пассажиров в автобус, если автобус не едет и есть место
     *
     * @param passenger новый пассажир
     */
    void addPassenger(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Нельзя добавить null-пассажира");
            return;
        }

        if (isGoing) {
            System.err.println("Автобус едет, нельзя добавлять пассажиров");
            return;
        }

        // можем добавлять пассажиров
        if (!isFull()) { // проверим, есть ли места в нашем автобусе
            System.out.println("В автобус прибыл новый пассажир - " + passenger.getName());
            this.passengers.add(passenger);
        }
    }

    public void setNumber(String number) {
        if (number != null && !number.equals("")) {
            this.number = number;
        } else {
            this.number = "DEFAULT";
        }
    }

    public String getNumber() {
        return number;
    }

    public boolean isGoing() {
        return isGoing;
    }

    public boolean isFull() {
        return passengers.size() >= PASSENGERS_MAX_COUNT;
    }
}
