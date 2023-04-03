package gamesave.gamesave.models;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Metas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private LocalDate inicio;
    @NotNull
    private LocalDate fim;
    @NotNull   
    private LocalDate horasDia;
    private Long id;

    protected Metas(){}

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
