package lesson14.appExample.repository;

import lesson14.appExample.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ArrayListToDoRepository implements ToDoRepository{

    private Integer idSequence = 1;
    private List<ToDo> database = new ArrayList<>();

    @Override
    public ToDo save(ToDo entity) {
        if (entity.getId() != null) {
            return update(entity);
        } else {
        entity.setId(idSequence);
        idSequence++;
        database.add(entity);
        return entity;
        }
    }

    private ToDo update(ToDo entity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (Objects.equals(existingEntity.getId(), entity.getId())) {
                database.set(i, entity);
                return entity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<ToDo> findAll() {
        return database;
    }

    @Override
    public Optional<ToDo> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<ToDo> findByUserId(Integer userId) {
        return database.stream()
                .filter(entity -> entity.getAuthor().getId().equals(userId))
                .toList();
    }

    @Override
    public boolean delete(Integer id) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (Objects.equals(existingEntity.getId(), id)) {
                return database.remove(existingEntity);
            }
        }
        throw new IllegalStateException("Failed to delete");
    }
}
