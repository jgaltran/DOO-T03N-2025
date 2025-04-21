package Alunos.Braian.Revisao;

import java.util.Scanner;

public class Veiculo {
  public Scanner scanner = new Scanner(System.in);
  private String modelo;
  private String marca;
  private Integer ano;

  public Veiculo(String modelo, String marca, Integer ano){
    this.modelo = modelo;
    this.marca = marca;
    this.ano = ano;
  }
  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }
  public Integer getAno() {
    return ano;
  }
  public void setModelo(String modelo){
    this.modelo = modelo;
  }
  public void setMarca(String marca){
    this.marca = marca;
  }
  public void setAno(Integer ano){
    this.ano = ano;
  }

  public Veiculo cadastrarVeiculo(Scanner scanner) {
      System.out.println("Qual é o modelo do seu veículo?");
      this.modelo = scanner.next();
      System.out.println("Qual é a marca do seu veículo?");
      this.marca = scanner.next();
      System.out.println("De qual ano é seu veículo?");
      this.ano = scanner.nextInt();

      return new Veiculo(modelo,marca,ano);
    }
    @Override
    public String toString() {
      return "Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano;
    }

}
