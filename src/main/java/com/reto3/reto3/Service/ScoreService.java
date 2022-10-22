package com.reto3.reto3.Service;

import com.reto3.reto3.Modelo.Score;
import com.reto3.reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public  Score save(Score sc){
        if(sc.getIdScore()== null){
            return  scoreRepository.save(sc);
        }else {
            Optional<Score> e = scoreRepository.getScore(sc.getIdScore());
            if (e.isPresent()){
                return sc;
            }else{
                return scoreRepository.save(sc);
            }
        }
    }
    public Score update(Score sc){
        if (sc.getIdScore()!=null){
            Optional<Score> q= scoreRepository.getScore(sc.getIdScore());
            if (!q.isPresent()){
                if (sc.getMessageText()!=null){
                    q.get().setMessageText(sc.getMessageText());
                }
                if (sc.getStars() != null && sc.getStars() >= 0 && sc.getStars() <= 5) {
                    q.get().setStars(sc.getStars());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else {
                return sc;
            }
        }else {
            return sc;
        }
    }
    public boolean deleteScore(int id){
        boolean flag=false;
        Optional<Score>sc= scoreRepository.getScore(id);
        if (sc.isPresent()){
            scoreRepository.delete(sc.get());
            flag=true;
        }
        return  flag;
    }
}
