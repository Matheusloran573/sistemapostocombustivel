public class BombaCombustivel {
    private String tipo;
    private double precoLitro;
    private double quantidadeDisponivel;

    public BombaCombustivel(String tipo, double precoLitro, double quantidadeInicial) {
        this.tipo = tipo;
        this.precoLitro = precoLitro;
        this.quantidadeDisponivel = quantidadeInicial;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoLitro() {
        return precoLitro;
    }

    public double getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void abastecer(double litros) {
        if (litros <= quantidadeDisponivel) {
            quantidadeDisponivel -= litros;
            System.out.println("Abastecimento realizado com sucesso!");
        } else {
            System.out.println("Quantidade insuficiente de combustível na bomba.");
        }
    }
}