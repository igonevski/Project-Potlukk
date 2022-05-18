package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.User;

public interface UserService {

    User registerUser(User user);

    User getUserById(int id);

    User updateUser(User user);

    boolean deleteUserById(int id);

}
