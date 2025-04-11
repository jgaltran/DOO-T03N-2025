package Alunos.Braian.Aula07;

import java.util.Date;
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
  Item item1 = new Item(1,"Orquídea","leve", 25.0);
  Item item2 = new Item(2,"Cacto",  "resistente", 80.0);
  Item[] itens = new Item[]{item1, item2};

  Pedido pedido1 = new Pedido(1, new Date(17/10/2024), new Date(23/10/2024), new Date(10/04/2025), "Carlos", "João", "Loja 1", itens);
  pedido1.gerarDescricaoVenda();
  pedido1.calcularValorTotal();
  }

}
