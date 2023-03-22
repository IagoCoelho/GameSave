package gamesave.gamesave.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Cadastro cadastro;
    Metas metas;

    public Jogos(Cadastro cadastro, Metas metas){
        this.cadastro = cadastro;
        this.metas = metas;
    }

    public Cadastro getCadastro(){
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro){
        this.cadastro = cadastro;
    }

    public Metas getMetas(){
        return metas;
    }

    public void setMetas(Metas metas){
        this.metas = metas;
    }
}
