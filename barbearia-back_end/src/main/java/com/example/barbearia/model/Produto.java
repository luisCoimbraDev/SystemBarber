package com.example.barbearia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Getter
@Setter
public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idprod;
        @Column(name = "product_name")
        private String productName;
        private double priceProduct;
        private int stockProduct;


}


