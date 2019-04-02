package com.butenko.vladyslav.foxconstructions.model.category;


import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.model.photo.Photo;
import com.butenko.vladyslav.foxconstructions.model.product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductCategory extends Model {


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="photo_id", referencedColumnName = "id")
    private Photo photo;

    @OneToMany
    private Set<Product> products;
}
