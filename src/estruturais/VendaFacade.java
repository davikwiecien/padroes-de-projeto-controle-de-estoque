package estruturais;

import criacionais.GerenciadorEstoque;
import model.Produto;
import comportamentais.DescontoStrategy;

public class VendaFacade {
    private GerenciadorEstoque estoque;

    public VendaFacade() {
        // a Facade já se conecta automaticamente com Singleton
        this.estoque = GerenciadorEstoque.getInstance();
    }

    // método único e simples para a Main chamar
    public void realizarVenda(int produtoId, int quantidadeDesejada, DescontoStrategy desconto) {
        Produto produto = estoque.buscarPorId(produtoId);
        
        // verifica se o produto existe
        if (produto == null) {
            System.out.println("Erro: Produto ID " + produtoId + " não encontrado no estoque\n");
            return;
        }

        // verifica se tem quantidade suficiente
        if (produto.getQuantidade() < quantidadeDesejada) {
            System.out.println("Erro: estoque insuficiente para o produto " + produto.getNome() + "\n");
            return;
        }

        // calcula os valores usando o Strategy
        double valorFinalUnidade = desconto.calcularDesconto(produto.getPreco());
        double valorTotal = valorFinalUnidade * quantidadeDesejada;

        // atualiza o estoque (faz baixa)
        produto.setQuantidade(produto.getQuantidade() - quantidadeDesejada);

        // imprime o recibo
        System.out.println("RECIBO DE VENDA");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade: " + quantidadeDesejada);
        System.out.printf("Valor original (unididade): R$ %.2f\n", produto.getPreco());
        System.out.printf("Valor com desconto (unidade): R$ %.2f\n", valorFinalUnidade);
        System.out.printf("total da venda: R$ %.2f\n\n", valorTotal);
       }
}
