import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static List<String> RegistroVendas = new ArrayList<>();
    static Map<String, Integer> VendasDiarias = new HashMap<>();

    public static void main(String[] args) {
        // Dados fixos da loja, vendedor e cliente
        String lojaNome = "My Plant Store";
        String lojaCNPJ = "00.000.000/0001-00";
        String lojaEndereco = "Rua das Plantas, Bairro Jardim, Cidade Verde";

        String vendedorNome = "Carlos";
        int vendedorIdade = 30;
        double salarioBase = 2500.00;
        double[] salariosRecebidos = {2500.00, 2700.00, 2600.00};

        String clienteNome = "Gabrielinha";
        int clienteIdade = 18;

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n--- My Plant ---");
            System.out.println("[1] - Ver dados da loja, vendedor e cliente");
            System.out.println("[2] - Calcular Preço Total");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Ver Registro de Vendas");
            System.out.println("[5] - Ver Vendas por Dia/Mês");
            System.out.println("[6] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirInformacoes(lojaNome, lojaCNPJ, lojaEndereco,
                            vendedorNome, vendedorIdade, salarioBase, salariosRecebidos,
                            clienteNome, clienteIdade);
                    break;
                case 2:
                    CalcularPrecoTotal(scanner);
                    break;
                case 3:
                    CalcularTroco(scanner);
                    break;
                case 4:
                    ExibirRegistroVendas();
                    break;
                case 5:
                    BuscarVendasPorDiaMes(scanner);
                    break;
                case 6:
                    System.out.println("Tchau Obrigado!! ");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void exibirInformacoes(String lojaNome, String lojaCNPJ, String lojaEndereco,
                                         String vendedorNome, int vendedorIdade, double salarioBase,
                                         double[] salariosRecebidos,
                                         String clienteNome, int clienteIdade) {
        System.out.println("\n===== LOJA =====");
        System.out.println("Nome Fantasia: " + lojaNome);
        System.out.println("CNPJ: " + lojaCNPJ);
        System.out.println("Endereço: " + lojaEndereco);

        System.out.println("\n===== VENDEDOR =====");
        System.out.println("Nome: " + vendedorNome);
        System.out.println("Idade: " + vendedorIdade);
        System.out.println("Loja: " + lojaNome);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Média dos últimos salários: R$ " + calcularMedia(salariosRecebidos));
        System.out.println("Bônus: R$ " + calcularBonus(salarioBase));

        System.out.println("\n===== CLIENTE =====");
        System.out.println("Nome: " + clienteNome);
        System.out.println("Idade: " + clienteIdade);
    }

    public static double calcularMedia(double[] salarios) {
        double soma = 0;
        for (double salario : salarios) {
            soma += salario;
        }
        return soma / salarios.length;
    }

    public static double calcularBonus(double salarioBase) {
        return salarioBase * 0.2;
    }

    public static void CalcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double total = quantidade * precoUnitario;
        double desconto = (quantidade > 10) ? total * 0.05 : 0;
        total -= desconto;

        System.out.printf("Preço total: R$ %.2f (Desconto aplicado: R$ %.2f)%n", total, desconto);

        System.out.print("Digite o dia da venda (formato dd/mm): ");
        String data = scanner.next();

        RegistroVendas.add("Data: " + data + " - Quantidade: " + quantidade + ", Valor: R$ " + String.format("%.2f", total));
        VendasDiarias.put(data, VendasDiarias.getOrDefault(data, 0) + quantidade);
    }

    public static void CalcularTroco(Scanner scanner) {
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        if (valorPago < valorCompra) {
            System.out.println("Valor insuficiente! O cliente precisa pagar mais.");
        } else {
            double troco = valorPago - valorCompra;
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
    }

    public static void ExibirRegistroVendas() {
        if (RegistroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            System.out.println("\n-- Registro de Vendas --");
            for (String venda : RegistroVendas) {
                System.out.println(venda);
            }
        }
    }

    public static void BuscarVendasPorDiaMes(Scanner scanner) {
        System.out.print("Digite a data para busca (formato dd/mm): ");
        String dataBusca = scanner.next();
        Integer vendas = VendasDiarias.get(dataBusca);
        if (vendas != null) {
            System.out.println("Vendas no dia " + dataBusca + ": " + vendas + " planta(s)");
        } else {
            System.out.println("Nenhuma venda registrada para essa data.");
        }
    }
}
