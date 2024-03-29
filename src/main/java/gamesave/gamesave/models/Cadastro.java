package gamesave.gamesave.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Cadastro {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 255)
    private String nomeJogo;

    @NotBlank @Size(min = 5, max = 255)
    private String categoria;

    @NotBlank @Size(min = 5, max = 255)
    private String plataforma;

    @NotBlank @Size(min = 5, max = 255)
    private String descricao;

}

