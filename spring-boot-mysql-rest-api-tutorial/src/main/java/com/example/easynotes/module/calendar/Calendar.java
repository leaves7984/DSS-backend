package com.example.easynotes.module.calendar;

import com.example.easynotes.module.schedule.Schedule;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="calendar_id")
    private Long id;

    @Column(name="date")
    private String date;


    @ManyToMany
    @JoinTable(name = "calendar_schedule", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<Schedule> schedule = new HashSet<>();

    public Calendar() {
    }

    public Calendar(String date) {
        this.date = date;

    }

}
