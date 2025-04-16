package Alunos.Braian.Aula06;

public class Cliente {
  private String nome;
  private int idade;
  private String cidade;
  private String bairro;
  private String rua;


  public Cliente(String nome, int idade, String cidade, String bairro, String rua){
    this.nome = nome;
    this.idade = idade;
    this.cidade = cidade;
    this.bairro = bairro;
    this.rua = rua;
  }
      public String getNome(){
        return nome;
      }
      public int getIdade(){
        return idade;
      }
      public String getcidade(){
        return cidade;
      }
      public String getBairro(){
        return bairro;
      }
      public String getRua(){
        return rua;
      }
      public void setNome(String nome){
        this.nome = nome;
      }
      public void setIdade(int idade){
        this.idade = idade;
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
      @Override
      public String toString(){
        return "Cliente [nome=" + nome + ", idade=" + idade + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + "]";
      }
      
      public void apresentarSe(){
      System.out.println("Olá, meu nome é " + this.nome);
      System.out.println("Tenho " + this.idade);
    }
}