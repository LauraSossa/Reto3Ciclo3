package com.reto3.reto3.Controller;

import com.reto3.reto3.Modelo.Admin;
import com.reto3.reto3.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id")int idAdmin){return adminService.getAdmin(idAdmin);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin a) {
        return adminService.save(a);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin a) {return adminService.update(a);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable("id")int idAdmin){return adminService.deleteAdmin(idAdmin);}




}
