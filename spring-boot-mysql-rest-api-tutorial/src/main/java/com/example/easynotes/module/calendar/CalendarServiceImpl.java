package com.example.easynotes.module.calendar;

import com.example.easynotes.module.calendar.Calendar;
import com.example.easynotes.module.calendar.CalendarRepository;
import com.example.easynotes.module.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public Calendar findByDate(String email) {


        return calendarRepository.findByDate(email);
    }
}
