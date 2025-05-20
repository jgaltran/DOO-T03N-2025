import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("\n--- Calculadora da Loja de Plantas ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
                continue;
            }
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número inteiro.");
            scanner.next();
        }
        int quantidade = scanner.nextInt();
        
        System.out.print("Digite o preço unitário da planta: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.next();
        }
        double precoUnitario = scanner.nextDouble();
        
        double total = quantidade * precoUnitario;
        System.out.printf("Preço total da compra: R$ %.2f\n", total);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.next();
        }
        double valorRecebido = scanner.nextDouble();
        
        System.out.print("Digite o valor total da compra: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.next();
        }
        double valorCompra = scanner.nextDouble();
        
        if (valorRecebido < valorCompra) {
            System.out.println("Valor recebido é insuficiente!");
        } else {
            double troco = valorRecebido - valorCompra;
            System.out.printf("Troco a ser dado: R$ %.2f\n", troco);
        }
    }
}
