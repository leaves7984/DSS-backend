package com.example.easynotes.auth;

import com.example.easynotes.auth.UserService;
import com.example.easynotes.module.calendar.Calendar;
import com.example.easynotes.auth.RoleRepository;
import com.example.easynotes.auth.UserRepository;
import com.example.easynotes.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;




    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Calendar findBydate(User user, String date) {
        for(Calendar calendar:user.getCalendar()){
            if(calendar.getDate().equals(date))
                return calendar;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
