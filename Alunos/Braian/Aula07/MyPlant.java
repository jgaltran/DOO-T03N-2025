package Alunos.Braian.Aula07;

import java.util.Scanner;

public class MyPlant {
  public static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    menu();
  }
  public static void menu(){
    int opcao = 0;
    while(opcao != 2){
      exibirMenu();
      opcao = scanner.nextInt();
      switch(opcao){
        case 1 -> criarPedido();
        case 2 -> System.out.println("Saindo...");
        default -> System.out.println("Opção inválida!");
      }
    }
  }
  public static void exibirMenu(){
  System.out.println("1 - Criar pedido");
  System.out.println("2 - Sair");
  }

  public static void criarPedido(){
  Item item1 = new Item("leve,frágil", 1, "Caneca", "Utilidade", 25.0);
  Item item2 = new Item("pesado,grande", 2, "Monitor", "Eletrônico", 800.0);
  Item[] itens = new Item[]{item1, item2};

  Pedido pedido1 = new Pedido("pedido", 1, new Date(), new Date(), new Date(), "Carlos", "João", "Loja 1", itens);
  pedido1.gerarDescricaoVenda();
  pedido1.calcularValorTotal();
  }

}
