package com.reto3.reto3.Controller;

import com.reto3.reto3.Modelo.Doctor;
import com.reto3.reto3.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id")int id){return doctorService.getDoctor(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor d) {
        return doctorService.save(d);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor d) {return doctorService.update(d);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteDoctor(@PathVariable("id")int id){return doctorService.deleteDoctor(id);}




}
