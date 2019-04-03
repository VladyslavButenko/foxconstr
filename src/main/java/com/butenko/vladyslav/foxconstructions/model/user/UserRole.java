package com.butenko.vladyslav.foxconstructions.model.user;

public enum UserRole {
    CLIENT,
    MANAGER,
    ADMIN;
    public String getDescription(){
        return toString();
    }
}
