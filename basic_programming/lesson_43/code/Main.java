import java.util.UUID;

/**
 * 7/18/2023
 * SimpleProject
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        User admin = new User(
                UUID.randomUUID().toString(),
                "Marsel",
                "Sidikov",
                "sidikov.marsel@gmail.com",
                "qwert007",
                User.Role.ADMIN,
                User.State.VERIFIED
        );

        User manager = new User(
                UUID.randomUUID().toString(),
                "Roman",
                "Popov",
                "roman@gmail.com",
                "qwert007",
                User.Role.MANAGER,
                User.State.VERIFIED
        );

        manager.confirm();

    }
}
