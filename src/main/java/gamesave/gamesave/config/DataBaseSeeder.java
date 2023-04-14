package gamesave.gamesave.config;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import gamesave.gamesave.models.Cadastro;
import gamesave.gamesave.repository.CadastroRepository;
import gamesave.gamesave.repository.JogosRepository;
import gamesave.gamesave.repository.MetasRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner{

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    MetasRepository metasRepository;

    @Override
    public void run(String... args) throws Exception {
    cadastroRepository.saveAll(List.of(
        new Cadastro(1L, "cs", "FPS", "PC", "jogo de tiro em primeira pessoa" ),
        new Cadastro(2L, "cs", "FPS", "PC", "jogo de tiro em primeira pessoa" ),
        new Cadastro(3L, "cs", "FPS", "PC", "jogo de tiro em primeira pessoa" )));

           
    }

        
    
}
