package com.butenko.vladyslav.foxconstructions.model.user;

import com.butenko.vladyslav.foxconstructions.model.model.Model;
import com.butenko.vladyslav.foxconstructions.model.order.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model {

    @Column(name = "name", nullable = false)
    private String name = "";

    @Column(name = "surname", nullable = false)
    private String surname = "";

    @Column(name = "userName", nullable = false)
    private String userName = "";

    @Column(name = "password", nullable = false)
    private String password = "";

    @Column(name = "email", nullable = false)
    private String email = "";

    @Column(name = "phone", nullable = false)
    private String phone = "";

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role = UserRole.CLIENT;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> clientOrders = new ArrayList<>();

    public User() {

    }

    //private List<Order> managerOrders = new ArrayList<>();
    // TODO DOBAVIT' MANAGERORDERS ESLI NUJNO BUDET

}
