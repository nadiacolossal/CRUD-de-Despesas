package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Despesa;

public class RemoverDespesa {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();
        dao.delete(28);

    }
}
