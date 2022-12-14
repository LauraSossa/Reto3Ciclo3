package com.reto3.reto3.Repository;

import com.reto3.reto3.Modelo.Reservation;
import com.reto3.reto3.Repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation>getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return reservationCrudRepository.findById(idReservation);
    }
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }
    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }


    /*public  List<CountCar> getTopCars(){
        List<CountCar>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByCar();
        for(int i=0;i<report.size();i++){
            res.add(new CountCar((Long)report.get(i)[1],(Car) report.get(i)[0]));
        }
        return res;
    }


    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

     */


}
