package com.example.easynotes.auth;

import com.example.easynotes.exception.UnAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
    @GetMapping("/user")
    public List<User> getUser() {

        return userService.getUsers();
    }
    @RequestMapping("/login")
    @ResponseBody
    public Object findByUsername(String username, String password) {

        System.out.println(username+" "+password);
        User user = userRepository.findByUsername(username);
        if(user.getPassword().equals(password)){
            return user;
        }else{
            throw new UnAuthorizedException("Full authentication is required to access this resource");
        }
    }

    @RequestMapping("/create")
    @ResponseBody
    public Boolean create(String email, String password, String username){
        User user = userRepository.findByUsername(username);
        System.out.println(email+" "+password+" "+username);
        if(user != null){
            return false;
        }
        try {
            user = new User(email, password, username);
            userRepository.save(user);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
            return true;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {

            userRepository.deleteById(id);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(Long id, String email, String username, String password) {
        try {
            User user = userRepository.getOne(id);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
}
