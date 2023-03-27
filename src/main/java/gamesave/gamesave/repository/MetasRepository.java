package gamesave.gamesave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Metas;

public interface MetasRepository extends JpaRepository<Metas, Long>{
    
}
