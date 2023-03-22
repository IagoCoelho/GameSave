package gamesave.gamesave.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeJogo;
    private String categoria;
    private String plataforma;
    private String descricao;

    public Cadastro(String nomeJogo, String categoria, String plataforma, String descricao){
        this.nomeJogo = nomeJogo;
        this.categoria = categoria;
        this.plataforma = plataforma;
        this.descricao = descricao;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomeJogo(){
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo){
        this.nomeJogo = nomeJogo;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getPlataforma(){
        return plataforma;
    }

    public void setPlataforma(String plataforma){
        this.plataforma = plataforma;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "Cadastro[nome do jogo: " + nomeJogo + ", categoria: " + categoria + ", plataforma: " + plataforma + ", descricao: " + descricao + "]";
    }
}

