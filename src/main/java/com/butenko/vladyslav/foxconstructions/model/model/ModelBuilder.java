package com.butenko.vladyslav.foxconstructions.model.model;

import com.butenko.vladyslav.foxconstructions.util.generator.Generator;
import com.butenko.vladyslav.foxconstructions.util.generator.StringGenerator;
import lombok.Getter;

public abstract class ModelBuilder<T extends Model, B extends ModelBuilder<T, B>> implements Builder<T> {

    private long id;

    protected ModelBuilder() {

    }


    public T build(final T model) {
        model.setId(getId());
        return null;
    }

    public String generateRandomString() {
        Generator<String> generator = new StringGenerator(8);
        return generator.generate();
    }


    private long getId() {
        return (this.id >= 0) ? this.id : 0;
    }
}
