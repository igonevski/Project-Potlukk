package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.User;
import dev.group1.Potlukk.exceptions.IncorrectLoginCredentialsException;
import dev.group1.Potlukk.exceptions.UserNotFoundException;
import dev.group1.Potlukk.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo userRepo;


    @Override
    public User login(String username, String password) {
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException();
        }

        if(user.getPassword().equals(password)){
            return user;
        }else{
            throw new IncorrectLoginCredentialsException();
        }
    }
}
