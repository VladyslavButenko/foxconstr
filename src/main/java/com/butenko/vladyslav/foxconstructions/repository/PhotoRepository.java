package com.butenko.vladyslav.foxconstructions.repository;

import com.butenko.vladyslav.foxconstructions.model.photo.Photo;

public interface PhotoRepository extends MainRepository<Photo> {

    Photo findByTitle(String title);

    void deleteByTitle(String title);
}
