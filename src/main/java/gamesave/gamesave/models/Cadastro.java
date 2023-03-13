package gamesave.gamesave.models;

public class Cadastro {
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

