package criacionais;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEstoque {
    // a única instância da classe armazenada na memória
    private static GerenciadorEstoque instancia;
    
    // lista de produtos que simulan um banco de dados
    private List<Produto> produtos;

    // construtor privado (ninguém fora daqui pode fazer "new GerenciadorEstoque()")
    private GerenciadorEstoque() {
        this.produtos = new ArrayList<>();
    }

    // ponto de acesso global (assim que as outras classes pegam o estoque)
    public static GerenciadorEstoque getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorEstoque();
        }
        return instancia;
    }

    //Métodos básicos do estoque 

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        // retorna null  se o produto não existir
        return null; 
    }

    public void exibirEstoque() {
        System.out.println("ESTOQUE ATUAL DA LOJA");
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p.toString());
            }
        }
        System.out.println("=============================\n");        

    }

    // atualiza o preço de um produto existente
    public void atualizarPrecoProduto(int id, double novoPreco) {
        Produto p = buscarPorId(id);
        if (p != null) {
            p.setPreco(novoPreco);
            System.out.println("Preço do produto '" + p.getNome() + "' atualizado para R$ " + novoPreco + "\n");
        } else {
            System.out.println("Produto ID " + id + " não encontrado\n");
        }
    }

    // remove um produto do estoque
    public void removerProduto(int id) {
        Produto p = buscarPorId(id);
        if (p != null) {
            produtos.remove(p);
            System.out.println("Produto '" + p.getNome() + "' removido do estoque\n");
        } else {
            System.out.println("Produto ID " + id + " não encontrado\n");
        }
    }
}
