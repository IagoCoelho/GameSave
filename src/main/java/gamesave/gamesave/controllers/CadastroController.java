package gamesave.gamesave.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gamesave.gamesave.models.Cadastro;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CadastroController {
    
    @GetMapping("/api/cadastro")
    public Cadastro jogo() {
        var jogo = new Cadastro(
            nomeJogo: "r6",
            categoria: "fps",
            plataforma: "ps4",
            descricao: "jogo de tiro"
            );

        return jogo;
    }
    
}
