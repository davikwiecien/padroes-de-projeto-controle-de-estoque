package comportamentais;

public class DescontoLiquidacao implements DescontoStrategy {
    @Override
    public double calcularDesconto(double precoOriginal) {
        return precoOriginal * 0.70; // aplica 30% de desconto 
    }
}
