import java.util.Scanner;

public class CalculadoraPlantas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Bem-vindo a Calculadora da Gabrielinha!");
            System.out.println("[1] - Calcular Preco Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preco unitario da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = quantidade * precoUnitario;
                    System.out.printf("O preco total e: R$ %.2f%n", precoTotal);
                    break;

                case 2: 
                    System.out.print("Digite o valor recebido do cliente: ");
                    double valorRecebido = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorCompra = scanner.nextDouble();
                    double troco = valorRecebido - valorCompra;
                    if (troco < 0) {
                        System.out.println("O valor recebido e insuficiente para realizar a compra.");
                    } else {
                        System.out.printf("O troco a ser dado e: R$ %.2f%n", troco);
                    }
                    break;

                case 3: 
                    System.out.println("Saindo da calculadora");
                    break;

                default:
                    System.out.println("Opcao invalida");
            }
            System.out.println(); 
        } while (opcao != 3);

        scanner.close();
    }
}
