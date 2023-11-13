package lesson14.appExample.repository;

import lesson14.appExample.entity.ToDo;
import lesson14.appExample.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ArrayListUserRepository implements UserRepository{

    private Integer idSequence = 1;
    private List<User> database = new ArrayList<>();

    @Override
    public User save(User entity) {
        entity.setId(idSequence);
        idSequence++;
        database.add(entity);
        return entity;
        }

    @Override
    public List<User> findAll() {
        return database;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

}
