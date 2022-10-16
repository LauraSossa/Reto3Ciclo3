package com.reto3.reto3.Service;

import com.reto3.reto3.Modelo.Specialty;
import com.reto3.reto3.Repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }
    public Optional<Specialty> getDoctor(int id){
        return specialtyRepository.getSpecialty(id);
    }
    public Specialty save(Specialty s){
        if(s.getId()== null){
            return  specialtyRepository.save(s);
        }else {
            Optional<Specialty> e = specialtyRepository.getSpecialty(s.getId());
            if (e.isPresent()){
                return s;
            }else{
                return specialtyRepository.save(s);
            }
        }
    }
    public Specialty update(Specialty s){
        if (s.getId()!=null){
            Optional<Specialty> q= specialtyRepository.getSpecialty(s.getId());
            if (q.isPresent()){
                if (s.getName()!=null){
                    q.get().setName(s.getName());
                }
                if (s.getDescription()!=null){
                    q.get().setDescription(s.getDescription());
                }
                specialtyRepository.save(q.get());
                return q.get();
            }else {
                return s;
            }
        }else {
            return s;
        }
    }

}
