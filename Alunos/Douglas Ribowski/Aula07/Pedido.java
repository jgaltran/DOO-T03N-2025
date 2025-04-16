package fag;

import java.util.*;

public class Pedido {
    private int id;
    private Date dataCriacao, dataPagamento, dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
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
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("\n--- DETALHES DO PEDIDO ---");
        System.out.println("ID do Pedido: " + id);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Vendedor: " + vendedor.nome);
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.println("Endereço da loja: " + loja.endereco.apresentarLogradouro());
        System.out.println("Itens:");
        for (Item item : itens) {
            item.gerarDescricao();
        }
        System.out.println("Valor Total: R$" + calcularValorTotal());
        System.out.println("Reserva válida até: " + dataVencimentoReserva);
        System.out.println("----------------------------\n");
    }
}