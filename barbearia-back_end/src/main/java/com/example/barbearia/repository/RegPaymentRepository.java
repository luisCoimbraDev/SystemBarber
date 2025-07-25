package com.example.barbearia.repository;

import com.example.barbearia.model.RegistrationPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegPaymentRepository extends JpaRepository<RegistrationPayment, Long> {
}
