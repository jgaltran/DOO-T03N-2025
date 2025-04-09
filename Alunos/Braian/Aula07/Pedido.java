public class Pedido {
  private int id;
  private Date dataCriacao;
  private Date dataPagamento;
  private Date dataVencimentoReserva;
  private String cliente;
  private String vendedor;
  private String loja;
  private Item[] itens;

  public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, String cliente, String vendedor, String loja, Item[] itens) {
    this.id = id;
    this.dataCriacao = dataCriacao;
    this.dataPagamento = dataPagamento;
    this.dataVencimentoReserva = dataVencimentoReserva;
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.loja = loja;
    this.itens = itens;
  }

  public double calcularValorTotal() {
    double total = 0;
    for (Item item : itens) {
      total += item.getValor();
    }
    System.out.println("Valor total do pedido: R$" + total);
    return total;
  }

  public void gerarDescricaoVenda() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Pedido criado em: " + sdf.format(dataCriacao) + ", Valor total: R$" + calcularValorTotal());
  }

  public Date getDataVencimentoReserva() {
    return dataVencimentoReserva;
  }
}