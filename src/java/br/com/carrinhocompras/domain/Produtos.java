package br.com.carrinhocompras.domain;

import java.util.Date;


public class Produtos {
    
    private String codigoProduto;
    private String descricao;
    private int quantidade;
    private String unidadeMedida;
    private Float preco;
    private Date dataValidade;
    private int id ;
    private int quantidadeAdicionada;
    private float valorTotalDaCompra;

    public Produtos() {
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeAdicionada() {
        return quantidadeAdicionada;
    }

    public void setQuantidadeAdicionada(int quantidadeAdicionada) {
        this.quantidadeAdicionada = quantidadeAdicionada;
    }

    public float getValorTotalDaCompra() {
        return valorTotalDaCompra;
    }

    public void setValorTotalDaCompra(float valorTotalDaCompra) {
        this.valorTotalDaCompra = valorTotalDaCompra;
    }


    
}
