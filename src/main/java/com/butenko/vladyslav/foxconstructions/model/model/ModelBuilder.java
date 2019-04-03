package com.butenko.vladyslav.foxconstructions.model.model;

import lombok.Getter;

public class ModelBuilder<T extends Model, B extends ModelBuilder<T, B>> implements Builder<T> {

    @Getter
    private long id;

    protected ModelBuilder() {

    }


    public T build(final T model) {
        model.setId(getId());
        return null;
    }

    @Override
    public T build() {
        return null;
    }
}
