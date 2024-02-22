package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.util.List;
import java.util.Optional;

public class ListarDespesa {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();
//
//        List<Despesa> listDespesas = dao.findAll();
//
//        System.out.println(listDespesas.size());
//
//        for (Despesa despesa : listDespesas) {
//            System.out.println("id " + despesa.getId());
//            System.out.println("descricao: " + despesa.getDescricao());
//            System.out.println("valor: " + despesa.getValor());
//            System.out.println("------------");
//        }
//
//        Optional<Despesa> despesaOptional = dao.findById(58);
//        despesaOptional.ifPresent(despesa -> {
//            System.out.println("id: " + despesa.getId());
//            System.out.println("descricao: " + despesa.getDescricao());
//            System.out.println("valor: " + despesa.getValor());
//
//        });


//---------------------------------------------------------------


        List<Despesa> despesas = dao.findByCategoria(Categoria.TRANSPORTE);

        for (Despesa despesa : despesas) {
            System.out.println("id: " + despesa.getId());
            System.out.println("descricao: " + despesa.getDescricao());
            System.out.println("valor: " + despesa.getValor());
            System.out.println("categoria: " + despesa.getCategoria());
            System.out.println("---------------");
        }
    }
}
