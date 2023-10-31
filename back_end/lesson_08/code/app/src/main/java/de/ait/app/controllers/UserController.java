package de.ait.app.controllers;

import de.ait.model.User;

import java.util.List;

public interface UserController {
    public void create();
    public List<User> getAll();
    public void printAll();
}
