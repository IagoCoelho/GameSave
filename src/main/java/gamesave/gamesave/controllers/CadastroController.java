package gamesave.gamesave.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gamesave.gamesave.models.Cadastro;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CadastroController {
    
    @GetMapping("/api/cadastro")
    public Cadastro jogo() {
        var teste = new Cadastro(
            nomeJogo: "hogwarts legacy",
            categoria: "ação",
            plataforma: "ps5",
            descricao: "RPG de ação",
            LocalDate.now()
            );

        return teste;
    }
    
}
