package com.example.barbearia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idservico;
    @Column(name = "desc_service")
    private String descService;
    private double valueService;


}
