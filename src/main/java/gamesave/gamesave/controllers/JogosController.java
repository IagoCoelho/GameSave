package gamesave.gamesave.controllers;

import gamesave.gamesave.models.Jogos;
import gamesave.gamesave.repository.JogosRepository;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogosController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JogosRepository repository;

    @GetMapping
    public Page<Jogos> index(@RequestParam(required = false) String descricao, @PageableDefault(size = 5) Pageable pageable){
        if(descricao == null) return JogosRepository.findAll(pageable);
        return JogosRepository.findByDescricaoContaining(descricao, pageable);
    }

    @PostMapping
    public ResponseEntity<Jogos> create(@RequestBody @Valid Jogos jogo){
        log.info("cadastrando jogo: " + jogo);
        repository.save(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogos> show(@PathVariable Long id){
        log.info("buscando jogo com id " + id);
        return ResponseEntity.ok(getJogo(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Jogos> destroy(@PathVariable Long id){
        log.info("apagando jogo com id " + id);
        repository.delete(getJogo(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Jogos> update(@PathVariable Long id, @RequestBody @Valid Jogos jogo){
        log.info("alterando jogo com id " + id);
        Jogos existingJogo = getJogo(id);
        BeanUtils.copyProperties(jogo, existingJogo, "id");
        repository.save(existingJogo);
        return ResponseEntity.ok(existingJogo);
    }

    private Jogos getJogo(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado"));
    }

}
