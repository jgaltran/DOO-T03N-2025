import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyPlantGabriela {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        List<Loja> lojas = new ArrayList<>();
        int opcao;

        inicializarDadosTeste(lojas);

        do {
            System.out.println("1 - Gestao de Lojas");
            System.out.println("2 - Gestao de Vendedores");
            System.out.println("3 - Gestao de Clientes");
            System.out.println("4 - Registrar venda");
            System.out.println("5 - Ver vendas por dia");
            System.out.println("6 - Ver vendas por mes");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuLojas(scanner, lojas);
                case 2 -> menuVendedores(scanner, lojas);
                case 3 -> menuClientes(scanner, lojas);
                case 4 -> registrarVenda(scanner, vendas);
                case 5 -> mostrarVendasDia(scanner, vendas);
                case 6 -> mostrarVendasMes(scanner, vendas);
                case 7 -> System.out.println("Ate logo!");
                default -> System.out.println("Opçao invalida!");
            }
        } while (opcao != 7);
    }

    private static void inicializarDadosTeste(List<Loja> lojas) {
        Loja lojaPrincipal = new Loja("My Plant Gabriela Centro", "My Plant Gabriela LTDA", "12345678000100", 
                                     "Cascavel", "Centro", "Rua das Flores, 123");
        
        Vendedor vendedor1 = new Vendedor("Robso Silva", 28, lojaPrincipal, 
                                         "Cascavel", "Centro", "Rua A, 456", 2500.0);
        vendedor1.adicionarSalario(2500.0);
        vendedor1.adicionarSalario(2550.0);
        vendedor1.adicionarSalario(2600.0);
        
        Vendedor vendedor2 = new Vendedor("Joaquina Oliveira", 32, lojaPrincipal, 
                                          "Cascavel", "Centro", "Rua B, 789", 2800.0);
        vendedor2.adicionarSalario(2800.0);
        vendedor2.adicionarSalario(2850.0);
        vendedor2.adicionarSalario(2900.0);
        
        lojaPrincipal.adicionarVendedor(vendedor1);
        lojaPrincipal.adicionarVendedor(vendedor2);
        
        lojaPrincipal.adicionarCliente(new Cliente("tiao Souza", 45, "Cascavel", "Centro", "Rua C, 101"));
        lojaPrincipal.adicionarCliente(new Cliente("Josefina Costa", 38, "Cascavel", "Centro", "Rua D, 202"));
        
        lojas.add(lojaPrincipal);
    }

    private static void menuLojas(Scanner scanner, List<Loja> lojas) {
        System.out.println("\n Gestao Lojas");
        for (int i = 0; i < lojas.size(); i++) {
            System.out.println((i + 1) + " - " + lojas.get(i).getNomeFantasia());
        }
        System.out.print("Escolha uma loja para detalhes (0 para voltar): ");
        int escolha = scanner.nextInt();
        
        if (escolha > 0 && escolha <= lojas.size()) {
            Loja loja = lojas.get(escolha - 1);
            System.out.println("\nDetalhes da Loja:");
            loja.apresentarse();
            System.out.println("Total de vendedores: " + loja.contarVendedores());
            System.out.println("Total de clientes: " + loja.contarClientes());
        }
    }

    private static void menuVendedores(Scanner scanner, List<Loja> lojas) {
        System.out.println("\n Gestao Vendedores");
        for (Loja loja : lojas) {
            System.out.println("\nVendedores da loja " + loja.getNomeFantasia() + ":");
            for (Vendedor vendedor : loja.getVendedores()) {
                vendedor.apresentarse();
                System.out.printf("Media salarial: R$ %.2f\n", vendedor.calcularMedia());
                System.out.printf("Bônus: R$ %.2f\n", vendedor.calcularBonus());
                System.out.println("--------------------");
            }
        }
    }

    private static void menuClientes(Scanner scanner, List<Loja> lojas) {
        System.out.println("\nGestao Clientes");
        for (Loja loja : lojas) {
            System.out.println("\nClientes da loja " + loja.getNomeFantasia() + ":");
            for (Cliente cliente : loja.getClientes()) {
                cliente.apresentarse();
                System.out.println("--------------------");
            }
        }
    }

    static class Venda {
        int dia;
        int mes;
        int quantidade;
        double valor;

        public Venda(int dia, int mes, int quantidade, double valor) {
            this.dia = dia;
            this.mes = mes;
            this.quantidade = quantidade;
            this.valor = valor;
        }
    }

    static class Vendedor {
        private String nome;
        private int idade;
        private Loja loja;
        private String cidade;
        private String bairro;
        private String rua;
        private double salarioBase;
        private List<Double> salarioRecebido;

        public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, 
                        String rua, double salarioBase) {
            this.nome = nome;
            this.idade = idade;
            this.loja = loja;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.salarioBase = salarioBase;
            this.salarioRecebido = new ArrayList<>();
        }

        public void adicionarSalario(double salario) {
            salarioRecebido.add(salario);
        }

        public void apresentarse() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Loja: " + loja.getNomeFantasia());
        }

        public double calcularMedia() {
            return salarioRecebido.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
        }

        public double calcularBonus() {
            return salarioBase * 0.2;
        }

        public String getNome() { return nome; }
        public int getIdade() { return idade; }
        public Loja getLoja() { return loja; }
    }

    static class Cliente {
        private String nome;
        private int idade;
        private String cidade;
        private String bairro;
        private String rua;

        public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
        }

        public void apresentarse() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        }

        public String getNome() { return nome; }
        public int getIdade() { return idade; }
    }

    static class Loja {
        private String nomeFantasia;
        private String razaoSocial;
        private String cnpj;
        private String cidade;
        private String bairro;
        private String rua;
        private List<Vendedor> vendedores;
        private List<Cliente> clientes;

        public Loja(String nomeFantasia, String razaoSocial, String cnpj, 
                   String cidade, String bairro, String rua) {
            this.nomeFantasia = nomeFantasia;
            this.razaoSocial = razaoSocial;
            this.cnpj = cnpj;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.vendedores = new ArrayList<>();
            this.clientes = new ArrayList<>();
        }

        public void adicionarVendedor(Vendedor vendedor) {
            vendedores.add(vendedor);
        }

        public void adicionarCliente(Cliente cliente) {
            clientes.add(cliente);
        }

        public int contarClientes() {
            return clientes.size();
        }

        public int contarVendedores() {
            return vendedores.size();
        }

        public void apresentarse() {
            System.out.println("Nome Fantasia: " + nomeFantasia);
            System.out.println("CNPJ: " + cnpj);
            System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
        }

        public String getNomeFantasia() { return nomeFantasia; }
        public List<Vendedor> getVendedores() { return vendedores; }
        public List<Cliente> getClientes() { return clientes; }
    }

    // Metodo vendas
    private static void registrarVenda(Scanner scanner, List<Venda> vendas) {
        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        
        System.out.print("Mês: ");
        int mes = scanner.nextInt();
        
        System.out.print("Quantidade: ");
        int qtd = scanner.nextInt();
        
        System.out.print("Valor unitario: ");
        double valorUnit = scanner.nextDouble();

        double valorTotal = qtd * valorUnit;
        if (qtd > 10) {
            valorTotal *= 0.95; // 5% de desconto
        }

        vendas.add(new Venda(dia, mes, qtd, valorTotal));
        System.out.printf("Venda registrada! Total: R$ %.2f\n", valorTotal);
    }

    private static void mostrarVendasDia(Scanner scanner, List<Venda> vendas) {
        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        
        System.out.print("Mês: ");
        int mes = scanner.nextInt();

        int totalQtd = 0;
        double totalValor = 0;
        int contador = 0;

        for (Venda v : vendas) {
            if (v.dia == dia && v.mes == mes) {
                totalQtd += v.quantidade;
                totalValor += v.valor;
                contador++;
            }
        }

        System.out.printf("\nVendas no dia %d/%d:\n", dia, mes);
        System.out.println("Total de vendas: " + contador);
        System.out.println("Plantas vendidas: " + totalQtd);
        System.out.printf("Valor total: R$ %.2f\n", totalValor);
    }

    private static void mostrarVendasMes(Scanner scanner, List<Venda> vendas) {
        System.out.print("Mês: ");
        int mes = scanner.nextInt();

        int totalQtd = 0;
        double totalValor = 0;
        int contador = 0;

        for (Venda v : vendas) {
            if (v.mes == mes) {
                totalQtd += v.quantidade;
                totalValor += v.valor;
                contador++;
            }
        }

        System.out.printf("\nVendas no mês %d:\n", mes);
        System.out.println("Total de vendas: " + contador);
        System.out.println("Plantas vendidas: " + totalQtd);
        System.out.printf("Valor total: R$ %.2f\n", totalValor);
    }
}