package gamesave.gamesave.models;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class Jogos {
    
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

    @NotNull
    @ManyToOne
    Cadastro cadastro;
    Metas metas;
}
