package com.butenko.vladyslav.foxconstructions.repository;

import com.butenko.vladyslav.foxconstructions.model.category.ProductCategory;


public interface ProductCategoryRepository extends MainRepository<ProductCategory> {

    ProductCategory findByUrl(String url);

    void deleteByUrl(String url);

}
