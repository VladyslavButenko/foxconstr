package com.butenko.vladyslav.foxconstructions.model.photo;

import com.butenko.vladyslav.foxconstructions.model.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
@Data
@EqualsAndHashCode(callSuper = false)
public class Photo extends Model {

    public static final String PATH = System.getenv("PROJECT_HOME") +
            "/img";

    @Column(name = "title", nullable = false)
    private String title = "";

    @Column(name = "photo_short", nullable = false)
    private String photoLinkShort = "";

    @Column(name = "photo_long", nullable = false)
    private String photoLinkLong = "";

    protected Photo() {
    }



}
