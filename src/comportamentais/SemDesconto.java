package comportamentais;

public class SemDesconto implements DescontoStrategy {
    @Override
    public double calcularDesconto(double precoOriginal) {
        return precoOriginal; // retorna o preço normal sem alterar
    }
}