package Alunos.Gustavo_Baú.Aula06;

public class Principal {
    public static void main(String[] args) {
        Loja myPlant = new Loja("My Plant", "12.345.678/0001-00");
        
        Vendedor vendedor1 = new Vendedor("João Silva", 30, myPlant, 2000);
        Vendedor vendedor2 = new Vendedor("Maria Souza", 25, myPlant, 2200);
        myPlant.adicionarVendedor(vendedor1);
        myPlant.adicionarVendedor(vendedor2);
        
        Cliente cliente1 = new Cliente("Carlos Oliveira", 40);
        Cliente cliente2 = new Cliente("Ana Santos", 35);
        myPlant.adicionarCliente(cliente1);
        myPlant.adicionarCliente(cliente2);
        
        System.out.println("=== INFORMAÇÕES DA LOJA ===");
        myPlant.apresentarSe();
        System.out.println("Total de vendedores: " + myPlant.contarVendedores());
        System.out.println("Total de clientes: " + myPlant.contarClientes());
        
        System.out.println("\n=== VENDEDORES ===");
        for (Vendedor vendedor : myPlant.getVendedores()) {
            vendedor.apresentarSe();
            System.out.printf("Média salarial: R$%.2f%n", vendedor.calcularMedia());
            System.out.printf("Bônus: R$%.2f%n%n", vendedor.calcularBonus());
        }
        
        System.out.println("=== CLIENTES ===");
        for (Cliente cliente : myPlant.getClientes()) {
            cliente.apresentarSe();
        }
    }
}