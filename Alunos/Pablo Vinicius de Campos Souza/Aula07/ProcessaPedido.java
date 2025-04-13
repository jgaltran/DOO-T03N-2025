package Aula07;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente,
                            Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente,
                vendedor, loja, itens);

        if (confirmarPagamento(pedido)) {
            pedido.setDataPagamento(new Date()); // data atual
            System.out.println("Pagamento confirmado com sucesso.");
        } else {
            System.out.println("Pagamento não confirmado: reserva vencida.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date agora = new Date(); // data atual
        return !agora.after(pedido.getDataVencimentoReserva());
    }
}
