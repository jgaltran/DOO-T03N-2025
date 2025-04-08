import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Loja lojaMyPlant = new Loja("My plant",
                "MY PLANT LTDA",
                "70.289.962/0001-98",
                "Rio de Janeiro",
                "Barra da Tijuca",
                "R. Álvaro Moreira",
                new ArrayList<>(),
                new ArrayList<>());

        Cliente clienteGael = new Cliente("Gael Martin Nascimento",
                57,
                "Rio de Janeiro",
                "Bangu",
                "Caminho da Carranca");

        List<BigDecimal> salarioRecebidoVendedor = new ArrayList<>();
        salarioRecebidoVendedor.add(new BigDecimal("1500"));
        salarioRecebidoVendedor.add(new BigDecimal("3000"));
        salarioRecebidoVendedor.add(new BigDecimal("5000"));

        Vendedor vendedorBrenno = new Vendedor("Brenno César Bernardes",
                44,
                "Rio de Janeiro",
                "Santa Cruz",
                "Rua Vinte e Cinco",
                new BigDecimal("5000"),
                salarioRecebidoVendedor);

        lojaMyPlant.addCliente(clienteGael);
        lojaMyPlant.addVendedor(vendedorBrenno);

        //CÓDIGOS ASCII PARA MUDAR PARA NEGRITO E COR DO TEXTO PARA BRANCO BRILHANDO
        System.out.println("\033[1;97;5mMétodo apresentarSe da lojaMyPlant:\033[0m ");
        lojaMyPlant.apresentarSe();

        System.out.println("\033[1;97;5mMétodo contarClientes da lojaMyPlant:\033[0m ");
        lojaMyPlant.contarClientes();

        System.out.println("\033[1;97;5mMétodo contarVendedores da lojaMyPlant:\033[0m ");
        lojaMyPlant.contarVendedores();

        System.out.println("\033[1;97;5mMétodo apresentaSe do clienteGael:\033[0m ");
        clienteGael.apresentarSe();

        System.out.println("\033[1;97;5mMétodo calcularMedia do vendedorBrenno:\033[0m ");
        System.out.println("R$" + vendedorBrenno.calcularMedia() + " Média");

        System.out.println("\033[1;97;5mMétodo calcularBonus do vendedorBrenno:\033[0m ");
        System.out.println("R$" + vendedorBrenno.calcularBonus() + " Bônus");
    }
}