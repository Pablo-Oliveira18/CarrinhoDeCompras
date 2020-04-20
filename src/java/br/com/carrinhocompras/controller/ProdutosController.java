package br.com.carrinhocompras.controller;

import br.com.carrinhocompras.domain.Carrinho;
import br.com.carrinhocompras.domain.Produtos;
import br.com.carrinhocompras.util.UtilMensagens;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "produtosMB")
@SessionScoped
public class ProdutosController {
    private Produtos prod = new Produtos();
    private ArrayList <Produtos> produtos = new ArrayList<>();
    private int id = 1;
    private int idCompras = 1;
    private ArrayList<Carrinho> car = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private float total;


    
    

    public ProdutosController() {
        listar();
    }
    
    public String salvar(){
        produtos.add(prod);
        id++;
        UtilMensagens.mensagemSucesso("Sucesso", "Produto Salvo com sucesso !");
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    
    public String novo(){
        prod = new Produtos();
        prod.setId(id);
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
    
    public String adicionarCarrinho(Produtos prod){
        if(prod.getQuantidadeAdicionada() > prod.getQuantidade()){
            UtilMensagens.mensagemErro("Erro", "Quantidade insuficiente no estoque");
            prod.setQuantidadeAdicionada(0);
        }else{
            carrinho = new Carrinho();
            prod.setQuantidade(prod.getQuantidade() - prod.getQuantidadeAdicionada());
            carrinho.setValorTotal(prod.getPreco() * prod.getQuantidadeAdicionada());
            carrinho.setDescricaoProd(prod.getDescricao());
            carrinho.setQuantidade(prod.getQuantidadeAdicionada());
            carrinho.setCodigoCompra(idCompras);
            carrinho.setPreco(prod.getPreco());
            car.add(carrinho);
            for (int i = 0; i < car.size(); i++) {
                System.out.println(car.get(i).getCodigoCompra() + car.get(i).getDescricaoProd());
            }
            UtilMensagens.mensagemSucesso("Sucesso", "Produto adicionado com sucesso ao carrinho");
            idCompras++;
        }
        return "list.xhtml?faces-redirect=true";

    }
    
    public String removerCarrinho(Carrinho carrinho) {
        String aux = carrinho.getDescricaoProd();
        car.remove(carrinho);
        UtilMensagens.mensagemSucesso("Sucesso", "O Produto " + aux + " foi excluido com sucesso!");
        return "carrinho.xhtml?faces-redirect=true";
    }
    
    
    public String calcularTotal(){
        if(car.size() > 0){
            System.out.println("");
            for (int i = 0; i < car.size(); i++) {
                total = total + car.get(i).getValorTotal();
                System.out.println("total esta sendo de " + total);
            } 
            UtilMensagens.mensagemSucesso("Compra Finalizada", "O total de sua compra foi de " + total);
            for (int i = 0; i < car.size(); i++) {
                car.remove(i);
            }

        }else{
            UtilMensagens.mensagemErro("Erro", "Nenhum item no carrinho");
        }
        return "carrinho.xhtml?faces-redirect=true";


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
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
