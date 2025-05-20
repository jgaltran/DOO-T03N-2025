package fag;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = criarLojaFake();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar Pedido (dados fakes)");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                criarPedidoFake(loja);
            } else if (opcao == 2) {
                System.out.println("Encerrando sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static Loja criarLojaFake() {
        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", "123", "Loja 1");
        Loja loja = new Loja("My Plant", "My Plant LTDA", "00.000.000/0001-00", enderecoLoja);

        Endereco enderecoCliente = new Endereco("PR", "Cascavel", "Centro", "456", "Apto 101");
        Cliente cliente = new Cliente("Carlos", 30, enderecoCliente);
        loja.adicionaCliente(cliente);

        Endereco enderecoVendedor = new Endereco("PR", "Cascavel", "Centro", "789", "Casa");
        Vendedor vendedor = new Vendedor("Joana", 28, enderecoVendedor, loja, 2200);
        loja.adicionaVendedor(vendedor);

        return loja;
    }

    private static void criarPedidoFake(Loja loja) {
        Cliente cliente = loja.clientes.get(0);
        Vendedor vendedor = loja.vendedores.get(0);

        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Vaso de Cerâmica", "Decoração", 49.90));
        itens.add(new Item(2, "Planta Suculenta", "Planta", 19.90));

        Calendar cal = Calendar.getInstance();
        Date hoje = new Date();
        cal.setTime(hoje);
        cal.add(Calendar.DATE, 2);
        Date vencimento = cal.getTime();

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(new Random().nextInt(1000), cliente, vendedor, loja, itens, vencimento);
    }
}
