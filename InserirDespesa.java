package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.time.LocalDate;

public class InserirDespesa {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();

        Despesa despesa = new Despesa();

        despesa.setDescricao("Hortifruti");
        despesa.setCategoria(Categoria.ALIMENTACAO);
        despesa.setValor(50);
        despesa.setData(LocalDate.of(2021,04,12));

        Despesa despesaInserida = dao.save(despesa);

        System.out.println("Foi inserida a despesa com id: " + despesaInserida.getId());

    }
}
