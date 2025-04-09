package Alunos.Braian.Aula07;

public class Item {
  private String [] atributos;
  private Integer id;
  private String nome;
  private String tipo;
  private Double valor;

  public Item(String atributos, Integer id, String nome, String tipo, Double valor){
    this.atributos = atributos.split(",");
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.valor = valor;
  }

  public String getAtributos(){
    return String.join(", ", atributos);
  }
  public Integer getId(){
    return id;
  }
  public String getNome(){
    return nome;
  }
  public String getTipo(){
    return tipo;
  }
  public Double getValor(){
    return valor;
  }
  public void setAtributos(String atributos){
    this.atributos = atributos.split(",");
  }
  public void setId(Integer id){
    this.id = id;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setTipo(String tipo){
    this.tipo = tipo;
  }
  public void setValor(Double valor){
    this.valor = valor;
  }
  public void listarAtributos(){
    for (String atributo : atributos) {
        System.out.println(atributo.trim());
    }
  }
  public void gerarDescricao(){
    System.out.println("Id do item: \n"+ this.id + "Nome: \n" + this.nome + "Tipo:\n"+ this.tipo + "Valor: \n" + this.valor );
  }

}
