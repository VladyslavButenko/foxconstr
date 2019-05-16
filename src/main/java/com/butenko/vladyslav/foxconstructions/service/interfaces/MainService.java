package com.butenko.vladyslav.foxconstructions.service.interfaces;

import com.butenko.vladyslav.foxconstructions.model.model.Model;

import java.util.Collection;

public interface MainService<T extends Model> {
    void add(T model);

    void add(Collection<T> models);

    void update(T model);

    T get(long id);

    Collection<T> getAll();

    void remove(T model);

    void remove(long id);

    void remove(Collection<T> models);

    void removeAll();
}
