package com.butenko.vladyslav.foxconstructions.model.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class Model implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String DATE_PATTERN = "EEE, d MM yyy, HH:mm:ss";

    private static final String TIME_ZONE = "GMT+3";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected Model() {

    }

}
