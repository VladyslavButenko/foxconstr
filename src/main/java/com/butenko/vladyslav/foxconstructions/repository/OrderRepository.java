package com.butenko.vladyslav.foxconstructions.repository;

import com.butenko.vladyslav.foxconstructions.model.order.Order;

public interface OrderRepository extends MainRepository<Order> {

    Order findByNumber(String number);


    void deleteByNumber(String number);

}
