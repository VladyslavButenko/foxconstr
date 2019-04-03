package com.butenko.vladyslav.foxconstructions.model.order;

import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.model.saleposition.SalePosition;
import com.butenko.vladyslav.foxconstructions.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = false)
public class Order extends Model {

    @Column(name = "number", nullable = false)
    private String number = "";

    @Column(name = "date", nullable = false)
    private Date date = new Date();

    @Column(name = "address", nullable = false)
    private String address = "";

    @Column(name = "details")
    private String details = "";

    @Column(name = "description")
    private String description = "";

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status = OrderStatus.NEW;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private User client;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private User manager;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private Collection<SalePosition> salePositions;

}
