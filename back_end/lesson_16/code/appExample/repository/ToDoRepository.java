package lesson15.appExample.repository;

import lesson15.appExample.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    ToDo save(ToDo entity);

    List<ToDo> findAll();

    Optional<ToDo> findById(Integer id);

    List<ToDo> findByUserId(Integer userId);

    boolean delete(Integer id);
}
