package com.example.easynotes.module.calendar;

import com.example.easynotes.auth.User;
import com.example.easynotes.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CalendarController {

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/calendars")
    public List<Calendar> getAllCalendar() {
        return calendarRepository.findAll();
    }

    @RequestMapping("/calendars/create")
    @ResponseBody
    public String create(long id,String date){
        String userId = "";
        try {
            Calendar calendar = new Calendar(date);
            User user = userRepository.getOne(id);
            user.getCalendar().add(calendar);
            userId = String.valueOf(user.getId());
            calendarRepository.save(calendar);
            userRepository.save(user);

        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

}
