package gamesave.gamesave.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long>{

    Page<Jogos> findByDescricaoContaining(String descricao, Pageable pageable);
    
}
