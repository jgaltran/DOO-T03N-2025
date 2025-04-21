package Alunos.Braian.Revisao;

import java.util.Scanner;

public class Clientes {
  public Scanner scanner = new Scanner(System.in);
  private String nome;
  private Integer idade;
  private String cidade;
  private String bairro;
  private Integer rua;

    public Clientes(String nome, Integer idade, String cidade, String bairro, Integer rua){
      this.nome = nome;
      this.idade = idade;
      this.cidade = cidade;
      this.bairro = bairro;
      this.rua = rua;
    }
    public String getNome() {
      return nome;
    }
    public Integer getIdade() {
      return idade;
    }
    public String getCidade() {
      return cidade;
    }
    public String getBairro() {
      return bairro;
    }
    public Integer getRua() {
      return rua;
    }

    public void setNome(String nome){
      this.nome = nome;
    }
    public void setIdade(Integer idade){
      this.idade = idade;
    }
    public void setCidade(String cidade){
      this.cidade = cidade;
    }
    public void setBairro(String bairro){
      this.bairro = bairro;
    }
    public void setRua(Integer rua){
      this.rua = rua;
    }
    public static Clientes cadastrarCliente(Scanner scanner) {
      System.out.println("Qual seu nome?");
      String nome = scanner.next();
      System.out.println("Qual sua idade?");
      int idade = scanner.nextInt();
      System.out.println("Em qual cidade você mora?");
      String cidade = scanner.next();
      System.out.println("Em qual bairro você mora?");
      String bairro = scanner.next();
      System.out.println("Em qual rua você mora?");
      int rua = scanner.nextInt();

      return new Clientes(nome, idade, cidade, bairro, rua);

    }
    @Override
    public String toString() {
      return "Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade + ", Bairro: " + bairro + ", Rua: " + rua;
    }
  }

