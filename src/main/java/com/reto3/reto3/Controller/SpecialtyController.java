package com.reto3.reto3.Controller;


import com.reto3.reto3.Modelo.Specialty;
import com.reto3.reto3.Service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public List<Specialty> getAll(){
        return specialtyService.getAll();
    }
    @PostMapping("/save")
    public Specialty save(@RequestBody Specialty s){
        return specialtyService.save(s);
    }

}
