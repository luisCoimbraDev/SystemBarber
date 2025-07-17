package com.example.barbearia.repository;

import com.example.barbearia.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    public Servico findBydescService(String desc_service);

    List<Servico> findBydescServiceIn(List<String> servicos);
}
