package Alunos.Braian.Aula07;
public class Gerente {
  private String nome;
  private int idade;
  private String loja;
  private double salarioBase;
  private double[] salarioRecebido;
  private Endereco endereco;

  public Gerente(String nome, int idade, String loja, double salarioBase, double[] salarioRecebido, Endereco endereco) {
    this.nome = nome;
    this.idade = idade;
    this.loja = loja;
    this.salarioBase = salarioBase;
    this.salarioRecebido = salarioRecebido;
    this.endereco = endereco;
  }

  public void apresentarse() {
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Loja: " + loja);
  }

  public double calcularMedia() {
    double soma = 0;
    for (double salario : salarioRecebido) {
      soma += salario;
    }
    return soma / salarioRecebido.length;
  }

  public double calcularBonus() {
    return salarioBase * 0.35;
  }

  public void apresentarEndereco() {
    endereco.apresentarLogradouro();
  }
}
