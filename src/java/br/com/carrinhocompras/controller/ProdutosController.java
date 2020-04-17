package br.com.carrinhocompras.controller;

import br.com.carrinhocompras.domain.Produtos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "produtosMB")
@SessionScoped
public class ProdutosController {
    private Produtos prod = new Produtos();
    private ArrayList <Produtos> produtos = new ArrayList<>();
    

    public ProdutosController() {
        listar();
    }
    
    public String salvar(){
        produtos.add(prod);
        this.listar();
        int x = 1;
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("TEMOS: "+ produtos.get(i).getDescricao());
        }
        return "list.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        prod = new Produtos();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "";
    }
    
    public String buscaDados(Produtos prod) {
        this.prod = prod;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public List<Produtos> listar(){
        return produtos;
    }

    public Produtos getProd() {
        return prod;
    }

    public void setProd(Produtos prod) {
        this.prod = prod;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

 


    
    
    
    
}
