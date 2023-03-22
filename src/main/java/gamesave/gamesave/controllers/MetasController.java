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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gamesave.gamesave.models.Metas;
import gamesave.gamesave.repository.MetasRepository;

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
    public ResponseEntity<Metas> create(@RequestBody Metas Metas){
        log.info("cadastrando meta: " + Metas);
        
        repository.save(Metas);

        return ResponseEntity.status(HttpStatus.CREATED).body(Metas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Metas> jogo(@PathVariable Long id){
        log.info("buscando meta com id " + id);
        var MetasEncontrado = repository.findById(id);

        if(MetasEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(MetasEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Metas> destroy(@PathVariable Long id){
        log.info("apagando metas com id " + id);
        var MetasEncontrado = repository.findById(id);

        if(MetasEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(MetasEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Metas> update(@PathVariable long id, @RequestBody Metas metas){
        log.info("alterando meta com id " + id);
        var MetasEncontrado = repository.findById(id);

        if(MetasEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        metas.setId(id);

        repository.save(metas);

        return ResponseEntity.ok(metas);
    }
    
}