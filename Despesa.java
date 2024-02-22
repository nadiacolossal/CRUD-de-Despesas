package br.com.codandosimples.model;

import java.time.LocalDate;

public class Despesa {
    private Integer id;
    private String descricao;
    private LocalDate data;
    private double valor;
    private Categoria categoria;

    public int getId() {return Math.toIntExact(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

   public void add(Despesa despesa) {
    }
}
