package com.butenko.vladyslav.foxconstructions.model.product;

import com.butenko.vladyslav.foxconstructions.model.category.ProductCategory;
import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.model.photo.Photo;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends Model {

    @Column(name = "title", nullable = false)
    private String title = "";

    @Column(name = "url", nullable = false)
    private String url = "";

    @Column(name = "parameters")
    private String parameters = "";

    @Column(name = "description")
    private String description = "";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="photo_id", referencedColumnName = "id")
    private Photo photo;

    @Column(name = "price", nullable = false)
    private double price = 0;

    //SalePos

}
