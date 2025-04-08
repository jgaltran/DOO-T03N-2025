import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import objetos.loja;
import objetos.vendedor;

public class lojadavogabi {

    public static Scanner scan = new Scanner(System.in);

    static ArrayList<String> vendas = new ArrayList<>();
    static HashMap<String, Integer> vendasPorDia = new HashMap<>();
    static ArrayList<loja> lojas = new ArrayList<>();
    static loja lojaAtual;  // Loja atual selecionada

    public static void main(String[] args) {

        boolean loop = true;
        double valorProduto = 0;
        double total = 0;

        // Inicializando uma loja padrão
        loja lojaPadrao = new loja("Vogabi", "Rua das Plantas, 123");
        lojas.add(lojaPadrao);
        lojaAtual = lojaPadrao;

        // Criando vendedores para a loja
        vendedor vendedor1 = new vendedor("Maria", 1);
        vendedor vendedor2 = new vendedor("José", 2);
        lojaPadrao.adicionarVendedor(vendedor1);
        lojaPadrao.adicionarVendedor(vendedor2);

        System.out.println("Bom dia, vozinha!!" +
                "\nSeja bem-vinda a sua calculadora!");

        while (loop) {
            int escolha;

            System.out.println("\nEscolha uma das opcoes abaixo" +
                    "\n1) Calcular Total" +
                    "\n2) Calcular Troco" +
                    "\n3) Registrar Venda" +
                    "\n4) Exibir Vendas Registradas" +
                    "\n5) Exibir Vendas por Dia" +
                    "\n6) Exibir Vendedores" +
                    "\n7) Criar Nova Loja" +
                    "\n8) Selecionar Loja" +
                    "\n9) Sair");

            escolha = scan.nextInt();

            if (escolha == 1) {
                System.out.println("Voce escolheu calcular o total.");
                System.out.print("Informe a quantidade de plantas: ");

                int qtdProdutos = scan.nextInt();
                System.out.print("Informe o preco da planta: ");
                valorProduto = scan.nextDouble();

                total = valorProduto * qtdProdutos;
                double desconto = 0;

                if (qtdProdutos >= 10) {
                    desconto = total * 0.05;
                    total -= desconto;
                    System.out.printf("Voce recebeu um desconto de 5%%! O valor com desconto e: R$ %.2f\n", total);
                }

                vendas.add("Venda: Quantidade = " + qtdProdutos + ", Total = R$ " + total + ", Desconto = R$ " + desconto);
                System.out.printf("O total da compra e: R$ %.2f\n", total);
            }

            else if (escolha == 2) {
                System.out.println("Você escolheu calcular o troco.");

                System.out.printf("O total da compra deu: R$ %.2f\n", total);

                System.out.println("Insira o valor que o cliente lhe deu: ");
                double valorCliente = scan.nextDouble();

                double troco = valorCliente - total;

                if (valorCliente < total) {
                    System.out.printf("Dinheiro entregue pelo cliente não é suficiente.\nFalta a quantia de: R$ %.2f\n", -troco);
                } else if (valorCliente == total) {
                    System.out.println("Não há troco! O valor está exato.");
                } else {
                    System.out.printf("Você deve retornar o valor de: R$ %.2f\n", troco);
                }

            } else if (escolha == 3) {
                System.out.println("Você escolheu registrar uma venda.");
                System.out.print("Informe a quantidade de plantas: ");
                int qtdProdutos = scan.nextInt();
                System.out.print("Informe o preço da planta: ");
                valorProduto = scan.nextDouble();

                total = valorProduto * qtdProdutos;
                double desconto = 0;

                if (qtdProdutos >= 10) {
                    desconto = total * 0.05;
                    total -= desconto;
                }

                System.out.print("Informe o dia (DD): ");
                String dia = scan.next();
                System.out.print("Informe o mês (MM): ");
                String mes = scan.next();
                String chave = dia + "-" + mes;

                vendasPorDia.put(chave, vendasPorDia.getOrDefault(chave, 0) + qtdProdutos);

                vendas.add("Venda: Quantidade = " + qtdProdutos + ", Total = R$ " + total + ", Desconto = R$ " + desconto);
                System.out.printf("Venda registrada com sucesso! Total com desconto (se houver): R$ %.2f\n", total);
            }

            else if (escolha == 4) {
                System.out.println("Exibindo vendas registradas:");
                if (vendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada até o momento.");
                } else {
                    for (String venda : vendas) {
                        System.out.println(venda);
                    }
                }
            }

            else if (escolha == 5) {
                System.out.print("Informe o dia (DD): ");
                String dia = scan.next();
                System.out.print("Informe o mês (MM): ");
                String mes = scan.next();
                String chave = dia + "-" + mes;

                if (vendasPorDia.containsKey(chave)) {
                    System.out.printf("Quantidade total de vendas em %s: %d\n", chave, vendasPorDia.get(chave));
                } else {
                    System.out.println("Nenhuma venda registrada para essa data.");
                }
            }

            else if (escolha == 6) {
                System.out.println("Exibindo vendedores da loja:");
                lojaAtual.exibirVendedores();
            }

            else if (escolha == 7) {
                System.out.println("Criando uma nova loja...");
                System.out.print("Informe o nome da loja: ");
                String nomeLoja = scan.next();
                System.out.print("Informe o endereço da loja: ");
                String enderecoLoja = scan.next();
                loja novaLoja = new loja(nomeLoja, enderecoLoja);
                lojas.add(novaLoja);
                System.out.println("Nova loja criada com sucesso!");
            }

            else if (escolha == 8) {
                System.out.println("Escolha a loja:");
                for (int i = 0; i < lojas.size(); i++) {
                    System.out.println((i + 1) + ") " + lojas.get(i).getNome());
                }
                int escolhaLoja = scan.nextInt();
                if (escolhaLoja >= 1 && escolhaLoja <= lojas.size()) {
                    lojaAtual = lojas.get(escolhaLoja - 1);
                    System.out.println("Loja selecionada: " + lojaAtual.getNome());
                } else {
                    System.out.println("Opção inválida.");
                }
            }

            else if (escolha == 9) {
                System.out.println("Saindo... Até logo!");
                loop = false;
            }

            else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
