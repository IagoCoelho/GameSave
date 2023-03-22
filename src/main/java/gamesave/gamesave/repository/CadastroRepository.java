package gamesave.gamesave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
    
}
