package ch.nb.persistence.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> selectById(Long id);

    List<T> selectAll();

    void insert(T t);

    void update(T t, String[] params);

    void delete(T t);
}
