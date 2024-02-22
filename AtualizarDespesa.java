package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.time.LocalDate;
import java.util.Optional;

public class AtualizarDespesa {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();

        Optional<Despesa> despesaOptional = dao.findById(56);

        Despesa despesa = despesaOptional.get();

        despesaOptional.ifPresent(despesa1 -> {
            System.out.println("id: " + despesa.getId());
            System.out.println("descricao: " + despesa.getDescricao());
            System.out.println("valor: " + despesa.getValor());
        });

        despesa.setDescricao("gastos com dentista");
        despesa.setData(LocalDate.of(2021,12, 06));
        despesa.setValor(250);
        despesa.setCategoria(Categoria.OUTROS);

        dao.update(despesa);

    }

}
