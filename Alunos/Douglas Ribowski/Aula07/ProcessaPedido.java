package fag;

import java.util.*;

public class ProcessaPedido {
    public void processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens, Date dataVencimentoReserva) {
        Date agora = new Date();
        if (confirmarPagamento(agora, dataVencimentoReserva)) {
            Pedido pedido = new Pedido(id, agora, agora, dataVencimentoReserva, cliente, vendedor, loja, itens);
            pedido.gerarDescricaoVenda();
        } else {
            System.out.println("\n--- FALHA NA CRIAÇÃO DO PEDIDO ---");
            System.out.println("Reserva expirada. Pedido não pode ser processado.");
            System.out.println("----------------------------------\n");
        }
    }

    private boolean confirmarPagamento(Date agora, Date vencimento) {
        return agora.compareTo(vencimento) <= 0;
    }
}
