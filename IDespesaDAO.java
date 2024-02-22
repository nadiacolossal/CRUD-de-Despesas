package br.com.codandosimples.dao;

import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface IDespesaDAO {

    Despesa save(Despesa despesa);
    Despesa update(Despesa despesa);
    void delete(int id);
    List<Despesa> findAll();
    Optional<Despesa> findById(int id);
    List<Despesa> findByCategoria(Categoria categoria);


}
