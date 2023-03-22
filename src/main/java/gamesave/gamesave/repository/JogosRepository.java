package gamesave.gamesave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long>{
    
}
