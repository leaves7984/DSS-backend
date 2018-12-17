package com.example.easynotes.module.prescription;

import com.example.easynotes.module.patient.Patient;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String fromWhichDay;

    private String toWhichDay;

    private Integer time;

    private String type;

    private Integer weekTimes;

    private String description;

    private String username;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Patient patient;

    public Prescription() {
    }


}
