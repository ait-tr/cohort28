package autopark;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Driver {

    private String firstName;
    private String lastName;
    private int experience;

    private Bus bus; // автобус

    public Driver(String firstName, String lastName, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }

    /**
     * Назначает автобус водителю. Автобус не должен быть null.
     * Вызывает метод <code>setDriver</code> у автобуса
     * @param bus назначаемый автобус
     */
    public void setBus(Bus bus) {
        // если новый автобус не null
        if (bus != null) {
            // проверяем, а не едет ли автобус
            if (bus.isGoing()) { // если автобус едет
                System.err.println(this.firstName +": я не буду запрыгивать в едущий автобус!");
                return;
            }
            System.out.println(this.firstName + " пошел в автобус <" + bus.getNumber() + ">");
            this.bus = bus; // положили автобус водителю
            this.bus.setDriver(this); // положим в автобус себя
        } else { // если новый автобус null
            // выбрасываем ошибку
            throw new IllegalArgumentException("Нельзя положить null-автобус");
        }
    }

    /**
     * Останавливает вождение. Вызывает <code>stop</code> у
     */
    public void stopDrive() {
        if (bus != null) {
            System.out.println(this.firstName + " остановил автобус <" + this.bus.getNumber() + "> ");
            this.bus.stop();
        } else {
            System.err.println("У водителя нет автобуса, останавливать нечего");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void free() {
        this.bus = null;
    }

    /**
     * Метод позволяет водителю поехать вместе со своим автобусом.
     * Вызывает метод <code>go()</code> у автобуса
     */
    public void drive() {
        if (this.bus != null) {
            System.out.println(this.firstName + " поехал на автобусе " + this.bus.getNumber());
            this.bus.go(); // автобус поехал
        } else {
            System.err.println("У водителя " + this.firstName + " автобуса нет!");
        }
    }
}
