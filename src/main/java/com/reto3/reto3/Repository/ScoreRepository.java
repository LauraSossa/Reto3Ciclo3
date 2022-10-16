package com.reto3.reto3.Repository;

import com.reto3.reto3.Modelo.Score;
import com.reto3.reto3.Repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score>getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score sc){
        return scoreCrudRepository.save(sc);
    }
    public void delete(Score sc){
        scoreCrudRepository.delete(sc);
    }

}

