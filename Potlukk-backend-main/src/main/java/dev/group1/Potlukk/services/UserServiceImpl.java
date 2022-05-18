package dev.group1.Potlukk.services;

import dev.group1.Potlukk.entities.User;
import dev.group1.Potlukk.exceptions.UserNotFoundException;
import dev.group1.Potlukk.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> possibleUser = this.userRepo.findById(id);

        if(possibleUser.isPresent()){
            return possibleUser.get();
        }else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public User updateUser(User user) {
        User u = this.getUserById(user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        this.userRepo.save(u);
        return u;
    }

    @Override
    public boolean deleteUserById(int id) {
        Optional<User> possibleUser = this.userRepo.findById(id);

        if(possibleUser.isPresent()){
            this.userRepo.delete(possibleUser.get());
            return true;
        }else{
            throw new UserNotFoundException();
        }
    }
}
