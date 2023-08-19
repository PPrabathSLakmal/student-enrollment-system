package lk.prabath.test1.studentenrollmentsystembackend.dao;

import lk.prabath.test1.studentenrollmentsystembackend.entity.SupperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDao<T extends SupperEntity, ID extends Serializable> {
    long count();

    T save(T entity);

    void update(T entity);

    void deleteById(ID pk);

    Optional<T> findById(ID pk);

    List<T> findAll();

    boolean existById(ID pk);
}
