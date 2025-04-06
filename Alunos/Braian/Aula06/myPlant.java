package Alunos.Braian.Aula06;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myPlant {
  private String atributos;
  private String nomeFantasia;
  private String razaoSocial;
  private String cnpj;
  private String cidade;
  private String bairro;
  private String rua;
  private String vendedores;
  private String clientes;

  private static final List<Vendedor> listaVendedores = new ArrayList<>();
  private static final List<Cliente> listaClientes = new ArrayList<>();


  public void main(String[] args) {
  menu();
  }
  
  public void menu(){
  Scanner scanner = new Scanner(System.in);
  int opcao = 0;
    while(opcao != 7){
      exibirMenu();
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
          case 1  -> contarClientes();
          case 2  -> contarVendedores();
          case 3  -> apresentarSe();
          case 4 -> {
            if (!listaVendedores.isEmpty()) {
                listaVendedores.get(0).calcularMedia();
            }
        }
        case 5 -> {
            if (!listaVendedores.isEmpty()) {
                listaVendedores.get(0).calcularBonus();
            }
        }
        case 6 -> {
            if (!listaClientes.isEmpty()) {
                listaClientes.get(0).apresentarSe();
            }
          }
        case 7  -> System.out.println("Encerrando...");

        default -> System.out.println("Opção inválida!");
        }
    scanner.close();
  }

  }
  public void exibirMenu(){
    System.out.println("Digite 1 para: cadastrar um cliente");
    System.out.println("Digite 2 para: cadastrar um vendedor");
    System.out.println("Digite 3 para: contar clientes cadastrados");
    System.out.println("Digite 4 para: contar vendedores cadastrados");
    System.out.println("Digite 5 para: apresentar-se como vendedor ou cliente");
    System.out.println("Digite 6 para: sair do sistema");
  }
  public myPlant(String atributos, String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, String vendedores, String clientes){
    this.atributos = atributos;
    this.nomeFantasia = nomeFantasia;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.cidade = cidade;
    this.bairro = bairro;
    this.rua = rua;
    this.vendedores = vendedores;
    this.clientes = clientes;
  }
      public String getAtributos(){
        return atributos;
      }
      public String getNomeFantasia(){
        return nomeFantasia;
      }
      public String getrazaoSocial(){
        return razaoSocial;
      }
      public String getCnpj(){
        return cnpj;
      }
      public String getCidade(){
        return cidade;
      }
      public String getBairro(){
        return bairro;
      }
      public String getRua(){
        return rua;
      }
      public String getVendedores(){
        return vendedores;
      }
      public String getClientes(){
        return clientes;
      }
      public void setAtributos(String atributos){
        this.atributos = atributos;
      }
      public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
      }
      public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
      }
      public void setCnpj(String cnpj){
        this.cnpj = cnpj;
      }
      public void setCidade(String cidade){
        this.cidade = cidade;
      }
      public void setBairro(String bairro){
        this.bairro = bairro;
      }
      public void setRua(String rua){
        this.rua = rua;
      }
      public void setVendedores(String vendedores){
        this.vendedores = vendedores;
      }
      public void setClientes(String clientes){
        this.clientes = clientes;
      }

  private static void contarClientes(){
    Scanner scanner = new Scanner(System.in);
    scanner.close();
    System.out.println("Digite o nome do cliente: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a idade do cliente: ");
    int idade = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Digite a cidade do cliente: ");
    String cidade = scanner.nextLine();
    System.out.println("Digite o bairro do cliente: ");
    String bairro = scanner.nextLine();
    System.out.println("Digite a rua do cliente: ");
    String rua = scanner.nextLine();

    Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
    listaClientes.add(cliente);

    System.out.println("Cliente cadastrado com sucesso!");
    System.out.println("Total de clientes cadastrados: " + listaClientes.size());
    scanner.close();
  }
  private static void contarVendedores(){
    Scanner scanner = new Scanner(System.in);
    scanner.close();
    System.out.println("Digite o nome do vendedor: ");
    String nome = scanner.nextLine();
    System.out.println("Digite a idade do vendedor: ");
    int idade = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Digite a loja do vendedor: ");
    String loja = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Digite a cidade do vendedor: ");
    String cidade = scanner.nextLine();
    System.out.println("Digite o bairro do vendedor: ");
    String bairro = scanner.nextLine();
    System.out.println("Digite a rua do vendedor: ");
    String rua = scanner.nextLine();
    System.out.println("Digite a rua do vendedor: ");
    Double salarioBase = scanner.nextDouble();
    System.out.println("Digite o salario recebido do vendedor: ");
    Double salarioRecebido = scanner.nextDouble();

    Vendedor vendedor = new Vendedor(nome, idade, loja, cidade, bairro, rua, salarioBase, salarioRecebido);
    listaVendedores.add(vendedor);

    System.out.println("Vendedor cadastrado com sucesso!");
    System.out.println("Total de clientes cadastrados: " + listaVendedores.size());
  }

  public void apresentarSe(){
    System.out.println("Olá, nome fantasia da empresa é " + this.nomeFantasia);
    System.out.println("A razão social é:" + this.razaoSocial);
    System.out.println("O CNPJ é:" + this.cnpj);
    System.out.println("A cidade é:" + this.cidade);
    System.out.println("O bairro é:" + this.bairro);
    System.out.println("A rua é:" + this.rua);
  }
}
