package dev.group1.Potlukk.controller;

import dev.group1.Potlukk.dtos.LoginInfo;
import dev.group1.Potlukk.dtos.UserInfo;
import dev.group1.Potlukk.entities.User;
import dev.group1.Potlukk.services.LoginService;
import dev.group1.Potlukk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    //User login
    @PostMapping("/login")
    UserInfo login(@RequestBody LoginInfo loginInfo){
        User user = loginService.login(loginInfo.getUsername(), loginInfo.getPassword());
        UserInfo userInfo = new UserInfo(user.getId(), user.getUsername());
        return userInfo;
    }

    // Add new user
    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestBody User user){
        return this.userService.registerUser(user);
    }

    // Get a user
    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable int id){
        return this.userService.getUserById(id);
    }

    // Update User
    @PutMapping("/users/{id}")
    @ResponseBody
    public User updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        return this.userService.updateUser(user);
    }

    // Remove a user
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public boolean deleteUser(@PathVariable int id){
        return this.userService.deleteUserById(id);
    }
}
