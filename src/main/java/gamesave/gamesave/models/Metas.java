package gamesave.gamesave.models;
import java.time.LocalDate;

public class Metas {
    private LocalDate inicio;
    private LocalDate fim;   
    private LocalDate horasDia;
    private Long id;

    public Metas(LocalDate inicio, LocalDate fim, LocalDate horasDia){
        this.inicio = inicio;
        this.fim = fim;
        this.horasDia = horasDia;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public LocalDate getInicio(){
        return inicio;
    }

    public void setInicio(LocalDate inicio){
        this.inicio = inicio;
    }

    public LocalDate getFim(){
        return fim;
    }

    public void setFim(LocalDate fim){
        this.fim = fim;
    }

    public LocalDate getHorasDia(){
        return horasDia;
    }

    public void setHorasDia(LocalDate horasDia){
        this.horasDia = horasDia;
    }
}
