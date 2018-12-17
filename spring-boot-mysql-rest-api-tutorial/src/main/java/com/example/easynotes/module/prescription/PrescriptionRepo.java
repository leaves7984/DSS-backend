package com.example.easynotes.module.prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
}
