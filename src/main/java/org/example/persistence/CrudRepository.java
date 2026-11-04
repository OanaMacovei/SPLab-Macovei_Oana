package org.example.persistence;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deletedById(ID id);
    boolean existById(ID id);
}
