package com.example.barbearia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class RegistrationPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpayment;
    @OneToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate dtPayment;
    @ManyToMany
    @JoinTable(name = "registration_produtos", joinColumns = @JoinColumn(name = "id_payment"), inverseJoinColumns = @JoinColumn(name = "id_prod"))
    private List<Produto> productList;
    private double paymentPrice;

}
