import java.util.ArrayList;
import java.util.Scanner;

  public class CascavelMotors{

    private static java.util.ArrayList<Clientes> clientes = new java.util.ArrayList<>();
    private static java.util.ArrayList<Veiculo> veiculos = new java.util.ArrayList<>();

    public Scanner scanner = new Scanner(System.in);
    public void main (String[] args){
      menu();
    }
    public void menu(){
      System.out.println("|-- Cascavel Motors System --|");
      System.out.println("Qual opção deseja selecionar?");
      int opcao = scanner.nextInt();
      while(opcao!=9){
        exibirMenu();
        switch(opcao){

          case 1  -> {
            Clientes novo = Clientes.cadastrarCliente(scanner);
            clientes.add(novo);
            System.out.println("Cliente cadastrado com sucesso!");
          }
          case 2  -> System.out.println("teste 2");
          case 3  -> System.out.println("teste 3");
          case 4  -> System.out.println("teste 4");
          case 5  -> System.out.println("teste 5");
          case 6  -> System.out.println("teste 6");
          case 7  -> System.out.println("teste 7");
          case 8  -> System.out.println("teste 8");
          case 9  -> System.out.println("teste 9");
          case 10 -> System.out.println("Saíndo");
          default -> System.out.println("Erro");
      }
      scanner.close();
    }
  }
    public void exibirMenu(){
      System.out.println("Exibindo menu:");
      System.out.println("1- Cadastro de clientes:");
      System.out.println("2- Cadastro de veículos");
      System.out.println("3- Buscar veículo por modelo");
      System.out.println("4- Buscar veículo por marca");
      System.out.println("5- Registrar entra de um veículo");
      System.out.println("6- Registrar saída de um veículo");
      System.out.println("7- Verificar disponibilidade mecânicos para atendimento");
      System.out.println("8- Troca de óleo");
      System.out.println("9- Troca de peça");
      System.out.println("10- Sair");
    }
  }

