package com.reto3.reto3.Controller;

import com.reto3.reto3.Modelo.Score;
import com.reto3.reto3.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    @PostMapping("/save")
    public Score save(@RequestBody Score sc){
        return scoreService.save(sc);
    }

}
