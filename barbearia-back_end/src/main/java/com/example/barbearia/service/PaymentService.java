package com.example.barbearia.service;

import com.example.barbearia.model.Produto;
import com.example.barbearia.repository.RegPaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    public final RegPaymentRepository regPaymentRepository;

    public PaymentService(RegPaymentRepository regPaymentRepository) {this.regPaymentRepository = regPaymentRepository;}

    public void savePayment(String PaymentMethod, String PaymentStatus, LocalDate dtpagamento, List<String> Produtos, List<String> Servicos){

    }
}
