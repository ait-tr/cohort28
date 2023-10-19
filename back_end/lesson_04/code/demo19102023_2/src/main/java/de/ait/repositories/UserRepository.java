package de.ait.repositories;

import de.ait.model.User;

public interface UserRepository extends CrudRepository<User>{
    public User findByEmail(String email);
}
