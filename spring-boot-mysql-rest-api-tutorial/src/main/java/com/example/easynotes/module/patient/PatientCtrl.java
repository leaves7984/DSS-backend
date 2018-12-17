package com.example.easynotes.module.patient;

import com.example.easynotes.module.note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientCtrl {

    @Autowired
    PatientRepo patientRepo;
    @PostMapping("/patient")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientRepo.saveAndFlush(patient);
    }
    @GetMapping("/patient/{username}")
    public List<Patient> getPatient(@PathVariable String username) {
        return patientRepo.findByUsername(username);
    }
    @RequestMapping(value="/patient/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public Patient deletePatient(@PathVariable Long id){
        Optional<Patient> patient = patientRepo.findById(id);
        patientRepo.delete(patient.get());
        return patient.get();
    }
}
