package comportamentais;

public interface DescontoStrategy {
    // toda estratégia de desconto deverá ter esse método
    double calcularDesconto(double precoOriginal);
}