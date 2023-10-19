package repositories;

import model.User;

import java.util.List;

public interface CrudRepository<T> {
    void save(T item);
    T findByID(Long id);
    List<T> findAll();
    void deleteById(Long id);
    void  update(T item);

}
