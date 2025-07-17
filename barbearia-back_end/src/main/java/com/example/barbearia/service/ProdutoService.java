package com.example.barbearia.service;

import com.example.barbearia.model.Produto;
import com.example.barbearia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    public double getValorProdutos(List<String> produtos){
        //esse trecho que fiz, busca todos os produtos de uma vez só e faz um map para double pegando o preço e somando
        return produtoRepository.findByproductNameIn(produtos).stream().mapToDouble(prod-> prod.getPriceProduct()).sum();

    }


}
