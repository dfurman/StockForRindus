package de.es.dfurman.rindus.stock.modules.stock.model.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id);

    void create(T object);

    void delete(T object);

    T update(T object);

    List<T> findAll();

    int count();
}
