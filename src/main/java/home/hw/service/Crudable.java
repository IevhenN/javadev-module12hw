package home.hw.service;

import home.hw.entity.Client;

import java.io.Serializable;
import java.util.List;

public interface Crudable<T, ID extends Serializable> {
    ID create(T entity);

    void update(T entity);

    void delete(T entity);

    T getById(ID id);

    List<T> getAll();

}
