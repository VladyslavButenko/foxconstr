package com.butenko.vladyslav.foxconstructions.service.implementations;

import com.butenko.vladyslav.foxconstructions.model.category.ProductCategory;
import com.butenko.vladyslav.foxconstructions.repository.ProductCategoryRepository;
import com.butenko.vladyslav.foxconstructions.service.interfaces.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static com.butenko.vladyslav.foxconstructions.util.validator.Validator.*;

@Service
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.repository")

public class ProductCategoryServiceImpl extends MainServiceImpl<ProductCategory>
        implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional
    public ProductCategory get(String url) throws IllegalArgumentException,
            NullPointerException {

        if (isEmpty(url)) {
            throw new IllegalArgumentException("Wrong URL");
        }
        ProductCategory category = this.repository.findByUrl(url);
        if (isNull(category)) {
            throw new NullPointerException("No category by this URL " + url + "!");
        }
        return category;
    }

    @Override
    @Transactional
    public void remove(String url) {
        if (isNotEmpty(url)) {
            this.repository.deleteByUrl(url);
        }
    }
}
