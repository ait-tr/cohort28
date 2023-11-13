package lesson14.appExample.repository;

import lesson14.appExample.entity.ToDo;
import lesson14.appExample.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User entity);

    List<User> findAll();

    Optional<User> findById(Integer id);

}
