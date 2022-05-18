package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.User;

public interface LoginService {

    User login(String username, String password);
}
