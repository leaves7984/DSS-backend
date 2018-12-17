package com.example.easynotes.module.schedule;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name="fromWhichDay")
    private String fromWhichDay;

    @Column(name="toWhichDay")
    private String toWhichDay;

    @Column(name = "time")
    private Integer time;

    @Column(name = "sports")
    private String sports;

    @Column(name = "description")
    private String description;

    public Schedule() {
    }

    public Schedule(String fromWhichDay, String toWhichDay, Integer time, String sports, String description) {
        this.fromWhichDay = fromWhichDay;
        this.toWhichDay = toWhichDay;
        this.time = time;
        this.sports = sports;
        this.description = description;
    }

}
