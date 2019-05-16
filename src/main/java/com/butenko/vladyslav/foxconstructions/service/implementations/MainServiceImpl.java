package com.butenko.vladyslav.foxconstructions.service.implementations;

import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.repository.MainRepository;
import com.butenko.vladyslav.foxconstructions.service.interfaces.MainService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static com.butenko.vladyslav.foxconstructions.util.validator.Validator.*;

public abstract class MainServiceImpl<T extends Model> implements MainService<T> {

    private final MainRepository<T> repository;

    public MainServiceImpl(final MainRepository<T> repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void add(T model) {
        if (isNotNull(model)) {
            this.repository.save(model);
        }

    }

    @Override
    @Transactional
    public void add(final Collection<T> models) {
        if (isNotEmpty(models)) {
            this.repository.saveAll(models);
        }
    }

    @Override
    public void update(T model) {
        if (isNotNull(model)) {
            add(model);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T get(final long id) throws NullPointerException {
        final T model = this.repository.getOne(id);
        if (isNull(model)) {
            throw new NullPointerException("Cant find model by id " + id + "!");
        }
        return model;
    }

    @Override
    public Collection<T> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void remove(T model) {
        if (isNotNull(model)) {
            this.repository.delete(model);
        }
    }

    @Override
    public void remove(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void remove(Collection<T> models) {
        if (isNotEmpty(models)) {
            this.repository.deleteAll(models);
        }
    }

    @Override
    public void removeAll() {
        this.repository.deleteAll();
    }
}
