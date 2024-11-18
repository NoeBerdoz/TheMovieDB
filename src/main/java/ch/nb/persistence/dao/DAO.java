package ch.nb.persistence.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> selectById(Long id) throws SQLException;

    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t) throws SQLException;
}
