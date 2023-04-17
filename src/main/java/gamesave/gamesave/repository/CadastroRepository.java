package gamesave.gamesave.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import gamesave.gamesave.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
    
    Page<Cadastro> findByDescricaoContaining(String descricao, Pageable pageable);

}
