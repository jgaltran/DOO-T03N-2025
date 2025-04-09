package Alunos.Braian.Aula07;

import java.util.Date;

public class Pedido{
  private String atributos;
  private Integer id;
  private Date dataCriacao;
  private Date dataPagamento;
  private Date dataVencimentoReserva;
  private String cliente;
  private String vendedor;
  private String loja;
  private Item[] itens;

  public Pedido(String atributos, Integer id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, String cliente, String vendedor, String loja, Item[] itens){
    this.atributos = atributos;
    this.id = id;
    this.dataCriacao = dataCriacao;
    this.dataPagamento = dataPagamento;
    this.dataVencimentoReserva = dataVencimentoReserva;
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.loja = loja;
    this.itens = itens;
  }
  public void calcularValorTotal(){
    System.out.println("Pedido do cliente: " + cliente);
    for(Item item : itens){
      item.gerarDescricao();
    }
  }
  public void gerarDescricaoVenda(){
    double total = 0;
    for (Item item : itens){
      total += item.getValor();
    }
    System.out.println("Valor total do pedido:" + total);

  }
}
