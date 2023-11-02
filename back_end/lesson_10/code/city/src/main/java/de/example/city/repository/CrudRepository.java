package de.example.city.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,I> {
    List<T> findAll();
    T save(T entity);
    Optional<T> findById(I id);
    void deleteById(I id);
    long count();
}
