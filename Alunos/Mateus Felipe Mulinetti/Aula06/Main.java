import Objetos.Cliente;
import Objetos.Loja;
import Objetos.Vendedor;


public class Main {

    public static void main(String[] args) {
        Loja loja = getLoja();
        System.out.println("\n Vendedores registrados: \n");


        for (int i = 0; i < loja.contarVendedores(); ++i) {
            loja.vendedores[i].apresentarVendedor();
            double mediaSalarios = loja.vendedores[i].calcularMedia();
            double bonus = loja.vendedores[i].calcularBonus();
            double total = mediaSalarios + bonus;
            System.out.println("Media dos salarios: " + String.format("%.2f", mediaSalarios));
            System.out.println("soma da media dos salários e bonus: " + String.format("%.2f", total));
            System.out.println("bonus: " + bonus + "\n");
        }

        System.out.println();
        System.out.println(" Clientes registrados:");

        for (int i = 0; i < loja.contarClientes(); ++i) {
            loja.clientes[i].apresentarCliente();
        }


        System.out.println("\nTotal de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());
    }

    private static Loja getLoja() {
        Vendedor vendedor1 = new Vendedor("Pedro Paulo", 38, "My Plant", "Cascavel-PR", "Centro",
                "Rua fag", 2000.0);
        Vendedor vendedor2 = new Vendedor("Jacobe Vitor", 95, "My Plant", "Cascavel-PR", "Centro",
                "Rua Fag", 2200.0);
        Cliente cliente1 = new Cliente("Juca do Grau", 42, "Cascavel-PR", "Centro", "Rua 22");
        Cliente cliente2 = new Cliente("João Linguini", 33, "Cascavel-PR", "Centro", "Rua 69");
        Loja loja = new Loja("My Plant", "My Plant Comércio LTDA", "12.345.678/0001-90", "Cascavel-PR",
                "Centro", "Rua Fag", 10, 10);
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);
        loja.apresentarLoja();
        return loja;
    }
}