package com.example.easynotes.module.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findByUsername(String username);
}
