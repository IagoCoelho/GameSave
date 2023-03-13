package gamesave.gamesave.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gamesave.gamesave.models.Metas;
import java.time.LocalDate;

@RestController
public class MetasController {
    
    @GetMapping("/api/metas")
    public Metas horas(){
        var tempo = new Metas(
            inicio: "04/03/2023"
            );
            return tempo;
    }
}
