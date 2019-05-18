package com.butenko.vladyslav.foxconstructions.service.interfaces;

import com.butenko.vladyslav.foxconstructions.model.category.ProductCategory;

public interface ProductCategoryService extends MainService<ProductCategory> {

    ProductCategory get(String url);

    void remove(String url);
}
