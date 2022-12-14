package com.reto3.reto3.Service;

import com.reto3.reto3.Modelo.Doctor;
import com.reto3.reto3.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return doctorRepository.getDoctor(id);
    }
    public Doctor save(Doctor d){
        if(d.getId()== null){
            return  doctorRepository.save(d);
        }else {
            Optional<Doctor> e = doctorRepository.getDoctor(d.getId());
            if (e.isPresent()){
                return d;
            }else{
                return doctorRepository.save(d);
            }
        }
    }
    public Doctor update(Doctor d){
        if (d.getId()!=null){
            Optional<Doctor> q=doctorRepository.getDoctor(d.getId());
            if (q.isPresent()){
                if (d.getDepartment()!=null){
                    q.get().setDepartment(d.getDepartment());
                }
                if (d.getYear()!=null){
                    q.get().setYear(d.getYear());
                }
                if (d.getDescription()!=null){
                    q.get().setDescription(d.getDescription());
                }
                if (d.getName()!=null){
                    q.get().setName(d.getName());
                }
                if (d.getSpecialty()!=null){
                    q.get().setSpecialty(d.getSpecialty());
                }
                doctorRepository.save(q.get());
                return q.get();
            }else {
                return d;
            }
        }else {
            return d;
        }
    }
    public boolean deleteDoctor(int id){
        boolean flag=false;
        Optional<Doctor>d=doctorRepository.getDoctor(id);
        if (d.isPresent()){
            doctorRepository.delete(d.get());
            flag=true;
        }
        return  flag;
    }
}


