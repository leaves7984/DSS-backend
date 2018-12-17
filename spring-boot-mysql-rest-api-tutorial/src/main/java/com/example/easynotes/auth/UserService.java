package com.example.easynotes.auth;

import com.example.easynotes.module.calendar.Calendar;
import com.example.easynotes.auth.User;

public interface UserService {


    public User findUserByEmail(String email);

    public void saveUser(User user);
    public User findByUsername(String username);
    public Calendar findBydate(User user, String date);

}
