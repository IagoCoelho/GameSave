package gamesave.gamesave.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import gamesave.gamesave.exception.RestNotFoundException;
import gamesave.gamesave.models.Cadastro;
import gamesave.gamesave.repository.CadastroRepository;
import gamesave.gamesave.repository.JogosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/cadastro")
public class CadastroController {

    List<Cadastro> cadastro = new ArrayList<>();

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    JogosRepository jogosRepository;

    @GetMapping
public Page<Cadastro> index(@RequestParam(required = false) String descricao, @PageableDefault(size = 5) Pageable pageable){
    if(descricao == null) return cadastroRepository.findAll(pageable).getContent();
    return cadastroRepository.findByDescricaoContaining(descricao, pageable);
}

    @PostMapping
    public ResponseEntity<Cadastro> create(@RequestBody @Valid Cadastro cadastro){
        log.info("cadastrando jogo: " + cadastro);
        cadastroRepository.save(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> jogo(@PathVariable Long id){
        log.info("buscando jogo com id " + id);
        var cadastro = cadastroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Cadastro não encontrada"));
        return ResponseEntity.ok(cadastro);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> destroy(@PathVariable Long id){
        log.info("apagando cadastro com id " + id);
        var cadastro = cadastroRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("despesa não encontrada"));

            cadastroRepository.delete(cadastro);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro cadastro){
        log.info("alterando cadastro com id" + id);
        cadastroRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("cadastro não encontrada"));;

        cadastro.setId(id);
        cadastroRepository.save(cadastro);

        return ResponseEntity.ok(cadastro);
    }
    
}
