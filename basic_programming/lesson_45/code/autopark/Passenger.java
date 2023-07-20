package autopark;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Passenger {

    private String name;

    private Bus bus;

    private boolean inBus; // true - если человек уже в автобусе

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод, который отправляет пассажира в автобус.
     * Метод вызывает <code>addPassenger</code> у <code>bus</code>
     * @param bus автобус, в который отправляем этого пассажира
     */
    public void goToBus(Bus bus) {
        if (inBus) {
            System.err.println(this.name + ": Я что-ли на ходу буду выпрыгивать!");
            return;
        }

        if (bus == null) {
            System.err.println(this.name + ": я не могу пойти в несуществующий автобус!");
            return;
        }

        if (bus.isGoing()) {
            System.err.println(this.name + ": Да не буду я прыгать в едущий автобус!");
            return;
        }

        if (bus.isFull()) {
            System.err.println(this.name + ": Там места нет!");
            return;
        }
        // скажем, что мы закреплены за этим автобусом
        this.bus = bus;
        bus.addPassenger(this); // говорим автобусу, чтобы он нас добавил в качестве пассажиров
        this.inBus = true;
    }

    public void sayAbout() {
        if (inBus) {
            System.out.println(name + ": ура, я в автобусе <" + this.bus.getNumber() + "> ");
        } else {
            System.out.println(name + ": стою вот жду автобуса");
        }
    }
}
