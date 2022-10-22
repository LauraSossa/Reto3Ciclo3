package com.reto3.reto3.Service;

import com.reto3.reto3.Modelo.Admin;
import com.reto3.reto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int idAdmin) {
        return adminRepository.getAdmin(idAdmin);
    }

    public Admin save(Admin a) {
        if (a.getIdAdmin() == null) {
            return adminRepository.save(a);
        } else {
            Optional<Admin> e = adminRepository.getAdmin(a.getIdAdmin());
            if (e.isPresent()) {
                return adminRepository.save(a);
            } else {
                return a;
            }
        }
    }

    public Admin update(Admin a){
        if(a.getIdAdmin()!=null){
            Optional<Admin>q= adminRepository.getAdmin(a.getIdAdmin());
            if(!q.isPresent()){
                if(a.getPassword()!=null){
                    q.get().setPassword(a.getPassword());
                }
                if(a.getName()!=null){
                    q.get().setName(a.getName());
                }
                return adminRepository.save(q.get());
            }
        }
        return a;
    }
    public boolean deleteAdmin(int idAdmin){
        boolean flag=false;
        Optional<Admin>q=adminRepository.getAdmin(idAdmin);
        if (q.isPresent()){
            adminRepository.delete(q.get());
            flag=true;
        }
        return  flag;
    }

}
