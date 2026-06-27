package comportamentais;

public class DescontoPix implements DescontoStrategy {
    @Override
    public double calcularDesconto(double precoOriginal) {
        return precoOriginal * 0.90; // aplica 10% de desconto
    }
}