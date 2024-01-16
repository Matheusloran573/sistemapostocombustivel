import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = new Cliente("João", 1000.0);
        ArrayList<BombaCombustivel> bombas = new ArrayList<>();
        bombas.add(new BombaCombustivel("Gasolina", 4.5, 1000.0));
        bombas.add(new BombaCombustivel("Etanol", 3.0, 800.0));

        int escolha;
        do {
            System.out.println("\n==== Posto de Combustível ====");
            System.out.println("1. Consultar saldo do cliente");
            System.out.println("2. Abastecer veículo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Saldo do cliente " + cliente.getNome() + ": R$" + cliente.getSaldo());
                    break;
                case 2:
                    System.out.println("\nEscolha o tipo de combustível:");
                    for (int i = 0; i < bombas.size(); i++) {
                        System.out.println((i + 1) + ". " + bombas.get(i).getTipo());
                    }
                    int escolhaCombustivel = scanner.nextInt();
                    if (escolhaCombustivel >= 1 && escolhaCombustivel <= bombas.size()) {
                        BombaCombustivel bombaEscolhida = bombas.get(escolhaCombustivel - 1);
                        System.out.print("Digite a quantidade de litros a abastecer: ");
                        double litrosAbastecidos = scanner.nextDouble();
                        double valorTotal = litrosAbastecidos * bombaEscolhida.getPrecoLitro();

                        if (cliente.getSaldo() >= valorTotal) {
                            cliente.setSaldo(cliente.getSaldo() - valorTotal);
                            bombaEscolhida.abastecer(litrosAbastecidos);
                            System.out.println("Abastecimento realizado com sucesso!");
                            System.out.println("Novo saldo do cliente: R$" + cliente.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente para realizar o abastecimento.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 3);

        scanner.close();
    }
}
