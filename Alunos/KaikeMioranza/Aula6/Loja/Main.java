import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando a loja
        System.out.println("=== CADASTRO DA LOJA ===");
        System.out.print("Nome fantasia: ");
        String nomeFantasia = sc.nextLine();
        System.out.print("Razão social: ");
        String razaoSocial = sc.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = sc.nextLine();
        System.out.print("Cidade: ");
        String cidadeLoja = sc.nextLine();
        System.out.print("Bairro: ");
        String bairroLoja = sc.nextLine();
        System.out.print("Rua: ");
        String ruaLoja = sc.nextLine();

        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);

        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] Adicionar Vendedor");
            System.out.println("[2] Adicionar Cliente");
            System.out.println("[3] Mostrar dados da loja");
            System.out.println("[4] Contar clientes");
            System.out.println("[5] Contar vendedores");
            System.out.println("[6] Ver dados e salário dos vendedores");
            System.out.println("[7] Ver dados dos clientes");
            System.out.println("[0] Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRAR VENDEDOR ===");
                    System.out.print("Nome: ");
                    String nomeVendedor = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeVendedor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeVend = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairroVend = sc.nextLine();
                    System.out.print("Rua: ");
                    String ruaVend = sc.nextLine();
                    System.out.print("Salário base: ");
                    double salarioBase = sc.nextDouble();
                    sc.nextLine();

                    Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, nomeFantasia, cidadeVend, bairroVend, ruaVend, salarioBase);
                    loja.adicionarVendedor(vendedor);
                    System.out.println("✅ Vendedor adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== CADASTRAR CLIENTE ===");
                    System.out.print("Nome: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeCliente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeCli = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairroCli = sc.nextLine();
                    System.out.print("Rua: ");
                    String ruaCli = sc.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidadeCli, bairroCli, ruaCli);
                    loja.adicionarCliente(cliente);
                    System.out.println("✅ Cliente adicionado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n=== DADOS DA LOJA ===");
                    loja.apresentarSe();
                    break;

                case 4:
                    loja.contarClientes();
                    break;

                case 5:
                    loja.contarVendedores();
                    break;

                case 6:
                    System.out.println("\n=== VENDEDORES CADASTRADOS ===");
                    for (Vendedor v : loja.getVendedores()) {
                        v.apresentarSe();
                        System.out.println("Média dos salários: R$ " + v.calcularMedia());
                        System.out.println("Bônus: R$ " + v.calcularBonus());
                        System.out.println("-----------------------------");
                    }
                    break;

                case 7:
                    System.out.println("\n=== CLIENTES CADASTRADOS ===");
                    for (Cliente c : loja.getClientes()) {
                        c.apresentarSe();
                        System.out.println("-----------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
