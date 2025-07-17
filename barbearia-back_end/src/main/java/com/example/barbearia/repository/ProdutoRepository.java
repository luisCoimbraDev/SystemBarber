package com.example.barbearia.repository;

import com.example.barbearia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    public Produto findByproductName(String product_name);

    List<Produto> findByproductNameIn(List<String> produtos);
}
