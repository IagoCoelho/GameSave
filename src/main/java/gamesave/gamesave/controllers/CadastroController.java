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

import gamesave.gamesave.models.Cadastro;
import gamesave.gamesave.repository.CadastroRepository;


@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {
    Logger log = LoggerFactory.getLogger(CadastroController.class);

    List<Cadastro> cadastro = new ArrayList<>();

    @Autowired
    CadastroRepository repository;

    @GetMapping
    public List<Cadastro> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastro){
        log.info("cadastrando jogo: " + cadastro);
        
        repository.save(cadastro);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> jogo(@PathVariable Long id){
        log.info("buscando jogo com id " + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cadastroEncontrado.get());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> destroy(@PathVariable Long id){
        log.info("apagando cadastro com id " + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(cadastroEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro cadastro){
        log.info("alterando cadastro com id" + id);
        var cadastroEncontrado = repository.findById(id);

        if(cadastroEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        cadastro.setId(id);

        repository.save(cadastro);

        return ResponseEntity.ok(cadastro);
    }
    
}
