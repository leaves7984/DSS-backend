package com.example.easynotes.module.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PrescriptionCtrl {
    @Autowired
    PrescriptionRepo prescriptionRepo;

    @RequestMapping(value="/prescription", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Prescription addPrescription(@RequestBody Prescription data) {
        return prescriptionRepo.saveAndFlush(data);
    }

}
