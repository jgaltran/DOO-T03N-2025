package Alunos.Braian.Aula07;

public class Pessoa {
  protected String nome;
  protected int idade;
  protected String loja;

  public Pessoa(String nome, int idade, String loja) {
      this.nome = nome;
      this.idade = idade;
      this.loja = loja;
  }

  public void apresentarSe() {
      System.out.println("Nome: " + nome);
      System.out.println("Idade: " + idade);
      System.out.println("Loja: " + loja);
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public int getIdade() {
      return idade;
  }

  public void setIdade(int idade) {
      this.idade = idade;
  }

  public String getLoja() {
      return loja;
  }

  public void setLoja(String loja) {
      this.loja = loja;
  }
}
