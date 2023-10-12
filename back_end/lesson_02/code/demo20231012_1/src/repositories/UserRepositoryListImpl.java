package repositories;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryListImpl implements CrudRepository {
    private  Long  currentID=1L;
    private final List<User> users = new ArrayList<>();
    @Override
    public void save(User user) {
        users.add(user);
        user.setId(currentID++);
    }

    @Override
    public User findByID(Long id) {
        return users.stream()
                .filter(u->u.getId()== id)
                .findFirst()
                .get();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User user) {

    }
}
