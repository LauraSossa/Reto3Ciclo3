package com.reto3.reto3.Controller;

import com.reto3.reto3.Modelo.Doctor;
import com.reto3.reto3.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @PostMapping("/save")
    public Doctor save(@RequestBody Doctor d) {
        return doctorService.save(d);
    }
}
