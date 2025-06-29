package com.example.barbearia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Agendamento;
    @ManyToOne
    @JoinColumn(name = "id_Barber")
    private Barbeiro barbeiro;
    @ManyToMany
    @JoinTable(name = "agendamento_servico", joinColumns = @JoinColumn(name = "id_Agendamento"), inverseJoinColumns = @JoinColumn(name = "id_servico"))
    private List<Servico> servicos;
    private String clienteName;
    private LocalDate dayAgendamento;
    private LocalDateTime hourAgendamento;
    private double totalPrice;
    private char statusAgnd;

    public void caltotalPrice(){
        for(Servico servico : servicos)
            totalPrice+= servico.getValueService();
    }

}
