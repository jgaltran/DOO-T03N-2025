package Aula04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraGabrielinha {
    private static Map<String, Integer> vendasDiarias = new HashMap<>();
    private static Map<String, Double> valoresDiarios = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU DA DONA GABRIELINHA ===");
            System.out.println("1. Registrar venda");
            System.out.println("2. Consultar vendas por dia e mês");
            System.out.println("3. Salvar quantidade total de vendas do dia");
            System.out.println("4. Buscar quantidade total de vendas do dia");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    registrarVenda(scanner);
                    break;
                case 2:
                    consultarVendas(scanner);
                    break;
                case 3:
                    salvarQuantidadeTotal(scanner);
                    break;
                case 4:
                    buscarQuantidadeTotal(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void registrarVenda(Scanner scanner) {
        int dia = lerInteiro(scanner, "Informe o dia da venda: ");
        int mes = lerInteiro(scanner, "Informe o mês da venda: ");
        int quantidade = lerInteiro(scanner, "Informe a quantidade de plantas vendidas: ");
        double precoUnitario = lerDouble(scanner, "Informe o preço unitário da planta: ");

        String chave = dia + "/" + mes;
        vendasDiarias.put(chave, vendasDiarias.getOrDefault(chave, 0) + quantidade);
        valoresDiarios.put(chave, valoresDiarios.getOrDefault(chave, 0.0) + (quantidade * precoUnitario));

        System.out.println("✅ Venda registrada com sucesso!");
    }

    private static void consultarVendas(Scanner scanner) {
        int dia = lerInteiro(scanner, "Informe o dia da consulta: ");
        int mes = lerInteiro(scanner, "Informe o mês da consulta: ");
        String chave = dia + "/" + mes;

        int totalVendas = vendasDiarias.getOrDefault(chave, 0);
        double valorTotal = valoresDiarios.getOrDefault(chave, 0.0);

        System.out.println("Vendas no dia " + chave + ": " + totalVendas + " plantas");
        System.out.printf("Valor total arrecadado: R$ %.2f%n", valorTotal);
    }

    private static void salvarQuantidadeTotal(Scanner scanner) {
        int dia = lerInteiro(scanner, "Informe o dia que deseja salvar: ");
        int mes = lerInteiro(scanner, "Informe o mês: ");
        int quantidadeTotal = lerInteiro(scanner, "Informe a quantidade total de vendas nesse dia: ");

        String chave = dia + "/" + mes;
        vendasDiarias.put(chave, quantidadeTotal);
        valoresDiarios.putIfAbsent(chave, 0.0); // cria a chave se não existir no outro mapa

        System.out.println("Quantidade total de vendas salva com sucesso para " + chave);
    }

    private static void buscarQuantidadeTotal(Scanner scanner) {
        int dia = lerInteiro(scanner, "Informe o dia que deseja buscar: ");
        int mes = lerInteiro(scanner, "Informe o mês: ");
        String chave = dia + "/" + mes;

        int totalVendas = vendasDiarias.getOrDefault(chave, 0);
        System.out.println("🔍 Quantidade total de vendas no dia " + chave + ": " + totalVendas + " plantas");
    }

    // Utilitários para entrada segura
    private static int lerInteiro(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerDouble(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. Digite um número decimal com ponto: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
