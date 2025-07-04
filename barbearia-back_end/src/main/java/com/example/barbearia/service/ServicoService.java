package com.example.barbearia.service;
import com.example.barbearia.model.Servico;
import com.example.barbearia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService{

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico>getServicos(){
        return servicoRepository.findAll();
    }
}
