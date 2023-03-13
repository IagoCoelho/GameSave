package gamesave.gamesave.models;

public class Registrados {
    Cadastro cadastro;
    Metas metas;

    public Registrados(Cadastro cadastro, Metas metas){
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
