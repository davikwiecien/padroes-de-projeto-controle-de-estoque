package criacionais;

import model.Produto;

public class ProdutoBuilder {
    private int id;
    private String nome;
    private String tamanho;
    private double preco;
    private int quantidade;

    public ProdutoBuilder comId(int id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder comTamanho(String tamanho) {
        this.tamanho = tamanho;
        return this;
    }

    public ProdutoBuilder comPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public ProdutoBuilder comQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    // o método que finalmente junta tudo e cria o objeto produto real
    public Produto build() {
        return new Produto(id, nome, tamanho, preco, quantidade);
    }
}