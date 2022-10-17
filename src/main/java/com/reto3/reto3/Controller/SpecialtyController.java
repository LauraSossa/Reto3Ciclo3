package com.reto3.reto3.Controller;


import com.reto3.reto3.Modelo.Doctor;
import com.reto3.reto3.Modelo.Specialty;
import com.reto3.reto3.Service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public List<Specialty> getAll(){
        return specialtyService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty (@PathVariable("id")int id){return specialtyService.getSpecialty(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty s){
        return specialtyService.save(s);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty s) {
        return specialtyService.update(s);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSpecialty(@PathVariable("id")int id){
        return specialtyService.deleteSpecialty(id);}

}
