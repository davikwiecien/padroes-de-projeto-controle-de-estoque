import model.Produto;
import criacionais.ProdutoBuilder;
import criacionais.GerenciadorEstoque;
import estruturais.VendaFacade;
import comportamentais.DescontoPix;
import comportamentais.SemDesconto;
import comportamentais.DescontoLiquidacao;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o Sistema da Loja de Roupas...\n");


        // instanciando o estoque (singleton)
        GerenciadorEstoque estoque = GerenciadorEstoque.getInstance();

        // criação dos produtos usando Builder
        Produto camisa = new ProdutoBuilder()
                .comId(1)
                .comNome("Camisa Polo")
                .comTamanho("M")
                .comPreco(89.90)
                .comQuantidade(50)
                .build();

        Produto calca = new ProdutoBuilder()
                .comId(2)
                .comNome("Calça Jeans")
                .comTamanho("42")
                .comPreco(150.00)
                .comQuantidade(30)
                .build();

        Produto jaqueta = new ProdutoBuilder()
                .comId(3)
                .comNome("Jaqueta de Couro")
                .comTamanho("G")
                .comPreco(350.00)
                .comQuantidade(10)
                .build();

        // cadastro no estoque central
        estoque.adicionarProduto(camisa);
        estoque.adicionarProduto(calca);
        estoque.adicionarProduto(jaqueta);

        // mostra o estoque inicial
        estoque.exibirEstoque();

        // inicializa a fachada do Caixa (Facade)
        VendaFacade caixa = new VendaFacade();

        // teste de 1ª venda: 2 camisas no PIX (10% de desconto)
        System.out.println("Realizando 1ª venda (pix - 10% de desconto)...");
        caixa.realizarVenda(1, 2, new DescontoPix());

        // teste de 2º venda: 1 calça no cartão (preço normal)
        System.out.println("Realizando 2ª venda (cartão - sem desconto)...");
        caixa.realizarVenda(2, 1, new SemDesconto());

        // teste de 3ª venda: 1 jaqueta na liquidação (30% de desconto)
        System.out.println("Realizando 3ª venda (liquidação - 30% de desconto)...");
        caixa.realizarVenda(3, 1, new DescontoLiquidacao());

        // teste de 4ª venda: simulando erro (com estoque insuficiente)
        System.out.println("Realizando 4ª venda (testando estoque insuficiente)...");
        caixa.realizarVenda(2, 100, new SemDesconto());

        // teste de 5ª venda: simulando erro (produto inexistente)
        System.out.println("Realizando 5ª venda (teste de produto não encontrado)...");
        caixa.realizarVenda(99, 1, new SemDesconto());
        
        // mostrando o estoque depois das venda pra validar a baixa
        estoque.exibirEstoque();

        // teste de atualização de protudo
        System.out.println("Realizando teste de update (aumentando preço da Camisa Polo para R$ 99.90)...");
        estoque.atualizarPrecoProduto(1, 99.90);

        // teste de exclusão de produto
        System.out.println("Realizando teste de delete (removendo a Jaqueta de Couro do sistema)...");
        estoque.removerProduto(3);

        // mostrando o estoque final depois do update e delete
        estoque.exibirEstoque();

    }
}
