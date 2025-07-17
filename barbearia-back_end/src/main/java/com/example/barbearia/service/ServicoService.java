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

    public double getPriceServicos(List<String> servicos){
        //esse trecho busca por uma lista de serviços no banco de dados e faz um map para double e soma tudo
        return servicoRepository.findBydescServiceIn(servicos).stream().mapToDouble(ser->ser.getValueService()).sum();
    }
}
