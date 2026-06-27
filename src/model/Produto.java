package model;

public class Produto {
    private int id;
    private String nome;
    private String tamanho;
    private double preco;
    private int quantidade;

    // construtor completo que o Builder usará
    public Produto(int id, String nome, String tamanho, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // getters e setters 
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTamanho() { return tamanho; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    // para printar o produto de maneira mais fácil
    @Override
    public String toString() {
        return String.format("ID: %d | %s (%s) | Preço: R$ %.2f | Estoque: %d", 
                id, nome, tamanho, preco, quantidade);
    }
}
