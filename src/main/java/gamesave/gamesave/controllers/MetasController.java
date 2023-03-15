package gamesave.gamesave.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gamesave.gamesave.models.Metas;

@RestController
public class MetasController {
    Logger log = LoggerFactory.getLogger(MetasController.class);

    List<Metas> Metas = new ArrayList<>();

    @GetMapping("/api/metas")
    public List<Metas> index(){
        return Metas;
    }

    @PostMapping("/api/metas")
    public ResponseEntity<Metas> create(@RequestBody Metas Metas){
        log.info("cadastrando meta: " + Metas);
        Metas.setId(Metas.size() + 1l);
        Metas.add(Metas);
        return ResponseEntity.status(HttpStatus.CREATED).body(Metas);
    }

    @GetMapping("/api/metas/{id}")
    public ResponseEntity<Metas> jogo(@PathVariable Long id){
        log.info("buscando meta com id " + id);
        var MetasEncontrado = Metas.stream().filter(c -> c.getId().equals(id)).findFirst();

        if(MetasEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(MetasEncontrado.get());
    }

    @DeleteMapping("/api/Metas/{id}")
    public ResponseEntity<Metas> destroy(@PathVariable Long id){
        log.info("apagando metas com id " + id);
        var MetasEncontrado = Metas.stream().filter(c -> c.getId().equals(id)).findFirst();

        if(MetasEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Metas.remove(MetasEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}