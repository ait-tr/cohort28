import java.util.function.Predicate;

/**
 * 7/18/2023
 * SimpleProject
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class User { // класс, описывающий аккаунт на каком-либо сайте

    public enum Role {
        ADMIN, MANAGER, USER
    }

    public enum State {
        NOT_CONFIRMED, // не подтвержден, но прошел регистрацию
        CONFIRMED, // подтвердил свои данные, например, через email
        BANNED, // заблокирован администратором
        VERIFIED, // проверен администратором
        NOT_VERIFIED, // отклонен администратором
        DELETED // пользователь удален самим собой
    }

    private String id;

    private String firstName; // имя
    private String lastName; // фамилия

    private String email;

    private String password;

    private Role role; // роль пользователя

    private State state; // состояние пользователя

    private boolean isOnline;

    public User(String id,
                String firstName,
                String lastName,
                String email, String password,
                Role role,
                State state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public State getState() {
        return state;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

//    public void confirm() {
//        if (isNotConfirmed()) {
//            this.state = State.CONFIRMED;
//        } else {
//            throw new IllegalStateException("Не удалось подтвердить пользователя. Текущее состояние: " + this.state);
//        }
//    }

//    public void confirm() {
//        changeState(new Predicate<State>() {
//                        @Override
//                        public boolean test(State state) {
//                            return isNotConfirmed();
//                        }
//                    },
//                State.CONFIRMED,
//                "Не удалось подтвердить пользователя");
//    }

    public void confirm() {
        changeState(state -> isNotConfirmed(),
                State.CONFIRMED,
                "Не удалось подтвердить пользователя");
    }

    public void verify() {
        changeState(state -> isConfirmed(),
                State.VERIFIED,
                "Не удалось проверить пользователя");
    }

    public void decline() {
        changeState(state -> isConfirmed(),
                State.NOT_VERIFIED,
                "Нельзя отклонить пользователя");
    }

    public void delete() {
        changeState(state -> isVerified() || !isVerified(),
                State.DELETED,
                "Нельзя удалить пользователя");
    }

    public void ban() {
        changeState(state -> !isDeleted(),
                State.BANNED,
                "Нельзя заблокировать пользователя");
    }

    public boolean isConfirmed() {
        return this.state.equals(State.CONFIRMED);
    }

    public boolean isNotConfirmed() {
        return this.state.equals(State.NOT_CONFIRMED);
    }

    public boolean isVerified() {
        return this.state.equals(State.VERIFIED);
    }

    public boolean isDeleted() {
        return this.state.equals(State.DELETED);
    }

    public void changeState(Predicate<State> predicate, State newState, String errorMessage) {
        if (predicate.test(this.state)) {
            this.state = newState;
        } else {
            throw new IllegalStateException(errorMessage + " Текущее состояние: " + this.state);
        }
    }

    void setState(State state) {
        this.state = state;
    }
}
