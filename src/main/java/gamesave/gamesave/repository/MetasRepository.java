package gamesave.gamesave.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Metas;

public interface MetasRepository extends JpaRepository<Metas, Long>{
    
    Page<Metas> findByDescricaoContaining(String descricao, Pageable pageable);

}
