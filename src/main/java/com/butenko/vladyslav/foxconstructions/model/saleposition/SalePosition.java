package com.butenko.vladyslav.foxconstructions.model.saleposition;

import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.model.order.Order;
import com.butenko.vladyslav.foxconstructions.model.product.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sale_positions")
@Data
public class SalePosition extends Model {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(name = "number", nullable = false)
    private int number = 0;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //TODO PO4EMU REMOVE
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    public SalePosition(){

    }

}
