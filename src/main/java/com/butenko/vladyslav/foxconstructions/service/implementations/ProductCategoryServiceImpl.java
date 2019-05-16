package com.butenko.vladyslav.foxconstructions.service.implementations;

import com.butenko.vladyslav.foxconstructions.model.category.ProductCategory;
import com.butenko.vladyslav.foxconstructions.repository.ProductCategoryRepository;
import com.butenko.vladyslav.foxconstructions.service.interfaces.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import static com.butenko.vladyslav.foxconstructions.util.validator.Validator.*;

@Service
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.repository")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategory get(String url) {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("Blank URL");
        }
        ProductCategory category = this.repository.findByUrl(url);
        if (isNull(category)) {
            throw new NullPointerException("No category by this URL " + url + "!");
        }
        return category;
    }

    @Override
    public void remove(String url) {
        if (isNotEmpty(url)) {
            this.repository.deleteByUrl(url);
        }
    }
}
