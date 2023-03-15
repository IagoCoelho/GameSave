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

import gamesave.gamesave.models.Cadastro;


@RestController
public class CadastroController {
    Logger log = LoggerFactory.getLogger(CadastroController.class);

    List<Cadastro> cadastro = new ArrayList<>();

    @GetMapping("/api/cadastro")
    public List<Cadastro> index(){
        return cadastro;
    }

    @PostMapping("/api/cadastro")
    public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastro){
        log.info("cadastrando jogo: " + cadastro);
        cadastro.setId(cadastro.size() + 1l);
        cadastro.add(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
    }

    @GetMapping("/api/cadastro/{id}")
    public ResponseEntity<Cadastro> jogo(@PathVariable Long id){
        log.info("buscando jogo com id " + id);
        var cadastroEncontrado = cadastro.stream().filter(c -> c.getId().equals(id)).findFirst();

        if(cadastroEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(cadastroEncontrado.get());
    }

    @DeleteMapping("/api/cadastro/{id}")
    public ResponseEntity<Cadastro> destroy(@PathVariable Long id){
        log.info("apagando cadastro com id " + id);
        var cadastroEncontrado = cadastro.stream().filter(c -> c.getId().equals(id)).findFirst();

        if(cadastroEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        cadastro.remove(cadastroEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
