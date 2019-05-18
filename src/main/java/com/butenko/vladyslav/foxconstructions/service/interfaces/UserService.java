package com.butenko.vladyslav.foxconstructions.service.interfaces;

import com.butenko.vladyslav.foxconstructions.model.user.User;
import com.butenko.vladyslav.foxconstructions.model.user.UserRole;

import java.util.Collection;

public interface UserService extends MainService<User> {
    User getByName(String name);

    User getByUsername(String username);

    User getMainAdmin();

    Collection<User> getAdmins();

    Collection<User> getManagers();

    Collection<User> getClients();

    Collection<User> getPersonnel();

    User getAuthenticatedUser();

    void removeByName(String name);

    void removeByRole(UserRole role);

    void removePersonnel();


}
