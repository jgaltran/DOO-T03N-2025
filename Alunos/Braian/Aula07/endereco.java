package Alunos.Braian.Aula07;

public class MyPlant {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    int opcao;
    while (opcao != 3){
      exibirMenu();
      opcao = scanner.nextInt();
      scanner.nextLine();
      switch (opcao) {
        case 1 -> criarItem();
        case 2 -> criarPedido();
        case 3 -> System.out.println("Saindo...");
        default -> System.out.println("Opção inválida!");
      }
    }

  }

  public static void exibirMenu() {
    System.out.println("1. Criar Itens");
    System.out.println("2. Criar Pedido com dados fakes");
    System.out.println("3. Sair");
    System.out.print("Escolha uma opção: ");
  }

  public static void criarItem() {
    Item item1 = new Item(1, "Caneca", "Utilidade", 25.0);
    Item item2 = new Item(2, "Monitor", "Eletrônico", 800.0);

    item1.gerarDescricao();
    item2.gerarDescricao();
  }

  public static void criarPedido() {
    Item item1 = new Item(1, "Caneca", "Utilidade", 25.0);
    Item item2 = new Item(2, "Monitor", "Eletrônico", 800.0);
    Item[] itens = { item1, item2 };

    Pedido pedido = new Pedido(1, new Date(), new Date(), new Date(), "Carlos", "João", "Loja 1", itens);

    pedido.gerarDescricaoVenda();
    pedido.calcularValorTotal();
  }
}
