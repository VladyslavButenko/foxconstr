package com.butenko.vladyslav.foxconstructions.model.order;

public enum OrderStatus {
    NEW,
    WORK,
    DELIVERY,
    CLOSED,
    REJECTED;

    public String getDescription(){
        return toString();
    }
}
