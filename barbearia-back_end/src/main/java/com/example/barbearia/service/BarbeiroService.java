package com.example.barbearia.service;

import com.example.barbearia.model.Barbeiro;
import com.example.barbearia.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    public final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<Barbeiro> getBarbeiros(){
        return barbeiroRepository.findAll();
    }
}
