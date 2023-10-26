package de.ait.services;

import de.ait.model.User;

import java.util.List;

public interface UserService {
    public void createUser(String name, String email);
    public List<User> getAllUsers();
}
