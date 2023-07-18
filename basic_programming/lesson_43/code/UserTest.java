import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private User userForTest;

    @BeforeEach
    void setUp() {
        userForTest = new User(
                UUID.randomUUID().toString(),
                "Roman",
                "Popov",
                "roman@gmail.com",
                "qwert007",
                User.Role.MANAGER,
                User.State.NOT_CONFIRMED
        );
    }

    @Test
    public void correctConfirm() {
        userForTest.setState(User.State.NOT_CONFIRMED);
        userForTest.confirm();
        assertTrue(userForTest.isConfirmed());
    }

    @Test
    public void notCorrectConfirm() {
        userForTest.setState(User.State.VERIFIED);
        // assertThrows(тип ошибки которую ожидаете, в каком случае она должна возникнуть)
        // ИМЯ_КЛАССА.class -> получить тип
        assertThrows(IllegalStateException.class, () -> userForTest.confirm());
    }
}