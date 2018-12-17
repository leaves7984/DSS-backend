package com.example.easynotes.module.calendar;

import com.example.easynotes.module.calendar.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    public Calendar findByDate(String Date);
}
