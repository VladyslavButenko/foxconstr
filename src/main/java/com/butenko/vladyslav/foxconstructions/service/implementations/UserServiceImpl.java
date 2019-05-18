package com.butenko.vladyslav.foxconstructions.service.implementations;

import com.butenko.vladyslav.foxconstructions.model.user.User;
import com.butenko.vladyslav.foxconstructions.model.user.UserRole;
import com.butenko.vladyslav.foxconstructions.repository.MainRepository;
import com.butenko.vladyslav.foxconstructions.repository.UserRepository;
import com.butenko.vladyslav.foxconstructions.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.butenko.vladyslav.foxconstructions.util.validator.Validator.*;

@Service
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.repository")
public class UserServiceImpl extends MainServiceImpl<User> implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(MainRepository<User> repository, UserRepository repository1) {
        super(repository);
        this.repository = repository1;
    }

    @Override
    @Transactional
    public User getByName(String name) throws IllegalArgumentException,
            NullPointerException {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Wrong name");
        }
        User user = this.repository.findByName(name);
        if (isNull(user)) {
            throw new NullPointerException("No user with this name " + name);
        }
        return user;
    }

    @Override
    @Transactional
    public User getByUsername(String username) throws IllegalArgumentException,
            NullPointerException {
        if (isEmpty(username)) {
            throw new IllegalArgumentException("Wrong name");
        }
        User user = this.repository.findByUserName(username);
        if (isNull(user)) {
            throw new NullPointerException("No user with this username " + username);
        }
        return user;
    }

    @Override
    @Transactional
    public User getMainAdmin() {
        return new ArrayList<>(getAdmins()).get(0);
    }

    @Override
    @Transactional
    public Collection<User> getAdmins() {
        return this.repository.getAllByRole(UserRole.ADMIN);
    }

    @Override
    public Collection<User> getManagers() {
        return this.repository.getAllByRole(UserRole.MANAGER);
    }

    @Override
    @Transactional
    public Collection<User> getClients() {
        return this.repository.getAllByRole(UserRole.CLIENT);
    }

    @Override
    @Transactional
    public Collection<User> getPersonnel() {
        List<User> users = new ArrayList<>();
        users.addAll(getAdmins());
        users.addAll(getManagers());
        return users;
    }

    @Override
    @Transactional
    public User getAuthenticatedUser() {
        User user;
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        try {
            user = (User) authentication.getPrincipal();
        } catch (ClassCastException ex) {
            user = null;
            ex.printStackTrace();
        }
        return user;

    }

    @Override
    @Transactional
    public void removeByName(String name) {
        if (isNotEmpty(name)) {
            this.repository.deleteByName(name);
        }
    }

    @Override
    @Transactional
    public void removeByRole(UserRole role) {
        if (isNotNull(role)) {
            this.repository.deleteAllByRole(role);
        }
    }

    @Override
    @Transactional
    public void removePersonnel() {
         Collection<User> personnel = getPersonnel();
         if(isNotEmpty(personnel)){
             User admin = getMainAdmin();
             personnel.remove(admin);
             this.repository.deleteAll(personnel);
         }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
