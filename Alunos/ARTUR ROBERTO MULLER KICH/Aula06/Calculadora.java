import java.util.*;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Integer> vendasPorDia = new HashMap<>();

    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("Gabriel", 30, "My Plant", 2000f);
        Cliente c1 = new Cliente("Lucas", 25);

        Vendedor[] vendedores = {v1};
        Cliente[] clientes = {c1};

        Loja loja = new Loja("My Plant", "12.345.678/0001-99", vendedores, clientes);

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Calcular conta");
            System.out.println("2. Calcular troco");
            System.out.println("3. Registrar venda");
            System.out.println("4. Mostrar registro de vendas");
            System.out.println("5. Apresentar Loja");
            System.out.println("6. Apresentar Vendedor");
            System.out.println("7. Apresentar Cliente");
            System.out.println("8. Calcular Média e Bônus do Vendedor");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                scanner.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    conta();
                    break;
                case 2:
                    troco();
                    break;
                case 3:
                    registrarVendas();
                    break;
                case 4:
                    mostrarVendas();
                    break;
                case 5:
                    loja.apresentarse();
                    loja.contarVendedores();
                    loja.contarClientes();
                    break;
                case 6:
                    v1.apresentarse();
                    break;
                case 7:
                    c1.apresentarse();
                    break;
                case 8:
                    v1.calcularMedia();
                    v1.calcularBonus();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    public static void conta() {
        try {
            System.out.print("Quantas plantas você pegou? ");
            int plantas = scanner.nextInt();

            System.out.print("Qual o preço da planta? ");
            float preco = scanner.nextFloat();

            float total = plantas * preco;

            if (plantas > 10) {
                float desconto = total * 0.05f;
                total -= desconto;
                System.out.println("Você ganhou 5% de desconto!");
            }

            System.out.printf("O total é: R$ %.2f\n", total);
        } catch (InputMismatchException e) {
            System.out.println("Digite números válidos!");
            scanner.next();
        }
    }

    public static void troco() {
        try {
            System.out.print("Qual o valor da compra? ");
            float valor = scanner.nextFloat();

            System.out.print("Quanto você pagou? ");
            float pago = scanner.nextFloat();

            if (pago < valor) {
                System.out.println("Valor pago insuficiente.");
            } else {
                float troco = pago - valor;
                System.out.printf("O troco é: R$ %.2f\n", troco);
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite números válidos!");
            scanner.next();
        }
    }

    public static void registrarVendas() {
        try {
            System.out.print("Informe o dia da venda: ");
            int dia = scanner.nextInt();

            System.out.print("Informe o mês da venda: ");
            int mes = scanner.nextInt();

            System.out.print("Informe a quantidade de vendas: ");
            int quant = scanner.nextInt();

            String chave = dia + "-" + mes;
            vendasPorDia.put(chave, vendasPorDia.getOrDefault(chave, 0) + quant);

            System.out.println("Venda registrada para " + chave);
        } catch (InputMismatchException e) {
            System.out.println("Digite números válidos!");
            scanner.next();
        }
    }

    public static void mostrarVendas() {
        if (vendasPorDia.isEmpty()) {
            System.out.println("Nenhuma venda registrada");
            return;
        }

        System.out.println("Registro de Vendas (Dia-Mês: Quantidade):");
        for (Map.Entry<String, Integer> entry : vendasPorDia.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vendas");
        }

        System.out.print("\nDeseja consultar um dia específico? (s/n): ");
        char opcao = scanner.next().toLowerCase().charAt(0);
        if (opcao == 's') {
            try {
                System.out.print("Informe o dia: ");
                int dia = scanner.nextInt();
                System.out.print("Informe o mês: ");
                int mes = scanner.nextInt();

                String chave = dia + "-" + mes;
                int vendas = vendasPorDia.getOrDefault(chave, 0);

                if (vendas > 0) {
                    System.out.println("Vendas no dia " + dia + "/" + mes + ": " + vendas);
                } else {
                    System.out.println("Nenhuma venda registrada para " + dia + "/" + mes + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite números válidos!");
                scanner.next();
            }
        }
    }
}
