package br.com.carrinhocompras.domain;

import java.util.ArrayList;


public class Carrinho {
    
    private int codigoCompra;
    private String descricaoProd;
    private int quantidade;
    private float preco;
    private float valorTotal;

    public Carrinho() {
    }

    public Carrinho(int codigoCompra, String descricaoProd, int quantidade, float preco, float valorTotal) {
        this.codigoCompra = codigoCompra;
        this.descricaoProd = descricaoProd;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }

    

    
    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getDescricaoProd() {
        return descricaoProd;
    }

    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
