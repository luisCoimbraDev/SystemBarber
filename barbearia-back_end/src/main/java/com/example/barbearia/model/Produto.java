package com.example.barbearia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Getter
@Setter
public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id_prod;
        private String productName;
        private double priceProduct;
        private int stockProduct;


}


