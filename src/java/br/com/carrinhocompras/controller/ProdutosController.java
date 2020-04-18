package br.com.carrinhocompras.controller;

import br.com.carrinhocompras.domain.Produtos;
import br.com.carrinhocompras.util.UtilMensagens;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean (name = "produtosMB")
@SessionScoped
public class ProdutosController {
    private Produtos prod = new Produtos();
    private ArrayList <Produtos> produtos = new ArrayList<>();
    private int id = 0;
    
    

    public ProdutosController() {
        listar();
    }
    
    public String salvar(){
        prod.setId(id);
        produtos.add(prod);
        id++;
        UtilMensagens.mensagemSucesso("Sucesso", "Produto Salvo com sucesso !");
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        prod = new Produtos();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        prod.setCodigoProduto(prod.getCodigoProduto());
        prod.setDescricao(prod.getDescricao());
        prod.setQuantidade(prod.getQuantidade());
        prod.setUnidadeMedida(prod.getUnidadeMedida());
        prod.setDataValidade(prod.getDataValidade());
        prod.setPreco(prod.getPreco());
        UtilMensagens.mensagemSucesso("Sucesso", "Alteração concluida com sucesso !");
        
        return "list.xhtml?faces-redirect=true";

    }
    
    public String remover(Produtos produto){
        String aux = produto.getDescricao();
        produtos.remove(produto);
        UtilMensagens.mensagemSucesso("Sucesso", "O Produto "+aux +" foi excluido com sucesso!");
        this.listar();
        return "list.xhtml?faces-redirect=true";

    }
    
    public String buscaDados(Produtos prod) {
        this.prod = prod;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
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
