package com.reto3.reto3.Service;

import com.reto3.reto3.Modelo.Reservation;
import com.reto3.reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public  Reservation save(Reservation r){
        if(r.getIdReservation()== null){
            return  reservationRepository.save(r);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
    public Reservation update(Reservation r){
        if (r.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getReservation(r.getIdReservation());
            if (q.isPresent()){
                if (r.getStartDate()!=null){
                    q.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus()!=null){
                    q.get().setStatus(r.getStatus());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else {
                return r;
            }
        }else {
            return r;
        }
    }
    public boolean deleteReservation(int id){
        boolean flag=false;
        Optional<Reservation>r= reservationRepository.getReservation(id);
        if (r.isPresent()){
            reservationRepository.delete(r.get());
            flag=true;
        }
        return  flag;
    }
}
