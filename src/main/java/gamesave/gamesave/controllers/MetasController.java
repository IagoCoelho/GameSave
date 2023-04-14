package gamesave.gamesave.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import gamesave.gamesave.exception.RestNotFoundException;
import gamesave.gamesave.models.Metas;
import gamesave.gamesave.repository.MetasRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/metas")
public class MetasController {

    Logger log = LoggerFactory.getLogger(MetasController.class);

    List<Metas> Metas = new ArrayList<>();

    @Autowired
    MetasRepository repository;

    @GetMapping
    public List<Metas> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Metas> create(@RequestBody @Valid Metas Metas){
        log.info("cadastrando meta: " + Metas);
        
        repository.save(Metas);

        return ResponseEntity.status(HttpStatus.CREATED).body(Metas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Metas> jogo(@PathVariable Long id){
        log.info("buscando meta com id " + id);
        var metas = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Meta não encontrada"));;

        return ResponseEntity.ok(metas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Metas> destroy(@PathVariable Long id){
        log.info("apagando metas com id " + id);
        var metas = repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("meta não encontrada"));;

        repository.delete(metas);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Metas> update(@PathVariable long id, @RequestBody Metas metas){
        log.info("alterando meta com id " + id);
        repository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("meta não encontrada"));

        metas.setId(id);
        repository.save(metas);

        return ResponseEntity.ok(metas);
    }
    
}