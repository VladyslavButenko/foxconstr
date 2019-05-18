package com.butenko.vladyslav.foxconstructions.repository;

import com.butenko.vladyslav.foxconstructions.model.user.User;
import com.butenko.vladyslav.foxconstructions.model.user.UserRole;

import java.util.Collection;

public interface UserRepository extends MainRepository<User> {
    User findByName(String name);
    User findByUserName(String userName);
    Collection<User> getAllByRole(UserRole user);
    void deleteByName(String name);
    void deleteAllByRole(UserRole role);

}
