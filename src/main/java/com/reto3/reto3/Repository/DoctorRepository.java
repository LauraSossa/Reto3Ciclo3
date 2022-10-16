package com.reto3.reto3.Repository;

import com.reto3.reto3.Modelo.Doctor;
import com.reto3.reto3.Repository.crudRepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;
    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }
    public Doctor save(Doctor d){
        return doctorCrudRepository.save(d);
    }
    public void delete(Doctor d){
        doctorCrudRepository.delete(d);
    }

}
