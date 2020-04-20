package br.com.carrinhocompras.controller;

import br.com.carrinhocompras.domain.Carrinho;
import br.com.carrinhocompras.domain.Produtos;
import br.com.carrinhocompras.util.UtilMensagens;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoController {
    private ArrayList<Carrinho> car = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private Produtos prod;
    private int id = 1;
    private ProdutosController prods;

    public CarrinhoController() {
        
    }
    
    
    public String addCarrinho(Produtos prod){
        if (carrinho.getQuantidade() > prod.getQuantidade()) {
            UtilMensagens.mensagemErro("Erro", "Quantidade insuficiente no estoque");
            carrinho.setQuantidade(0);
        } else {
            carrinho = new Carrinho();
            prod.setQuantidade(prod.getQuantidade() - carrinho.getQuantidade());
            carrinho.setValorTotal(prod.getPreco() * carrinho.getQuantidade());
            carrinho.setDescricaoProd(prod.getDescricao());
            carrinho.setQuantidade(carrinho.getQuantidade());
            carrinho.setCodigoCompra(id);
            carrinho.setPreco(prod.getPreco());
            car.add(carrinho);
            UtilMensagens.mensagemSucesso("Sucesso", "Produto adicionado com sucesso ao carrinho");
            id++;
        }
        return "list.xhtml?faces-redirect=true";

    }

    public ArrayList<Carrinho> getCar() {
        return car;
    }

    public void setCar(ArrayList<Carrinho> car) {
        this.car = car;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    
}
