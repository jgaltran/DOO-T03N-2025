package Aula06;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String CIDADE = "São Paulo";
        final String bairro = "Centro";

        Loja loja1 = new Loja("Minha Loja", "Minha Loja Ltda", "12.345.678/0001-90",
                CIDADE, bairro, "Avenida Principal");

        System.out.println("=== APRESENTAÇÃO DA LOJA ===");
        loja1.apresentarSe();
        System.out.println();

        Vendedor vendedor1 = new Vendedor("João Silva", 30, CIDADE, bairro,
                "Rua das Flores", 2000.0);
        Vendedor vendedor2 = new Vendedor("Maria Santos", 28, CIDADE, bairro,
                "Rua dos Lírios", 2200.0);

        vendedor1.getSalariosRecebidos().addAll(Arrays.asList(1900.0, 2000.0, 2100.0));
        vendedor2.getSalariosRecebidos().addAll(Arrays.asList(2100.0, 2200.0, 2300.0));

        loja1.adicionarVendedor(vendedor1);
        loja1.adicionarVendedor(vendedor2);

        System.out.println("=== VENDEDORES ===");
        System.out.println("Total de vendedores: " + loja1.contarVendedores());
        System.out.println("\nApresentação dos Vendedores:");
        vendedor1.apresentarSe();
        System.out.printf("Média salarial: R$%.2f%n", vendedor1.calcularMedia());
        System.out.printf("Bônus: R$%.2f%n%n", vendedor1.calcularBonus());

        vendedor2.apresentarSe();
        System.out.printf("Média salarial: R$%.2f%n", vendedor2.calcularMedia());
        System.out.printf("Bônus: R$%.2f%n", vendedor2.calcularBonus());
        System.out.println();

        Cliente cliente1 = new Cliente("Carlos Oliveira", 40, CIDADE, bairro, "Rua A");
        Cliente cliente2 = new Cliente("Ana Pereira", 35, CIDADE, bairro, "Rua B");
        Cliente cliente3 = new Cliente("Pedro Souza", 28, CIDADE, bairro, "Rua C");


        System.out.println("=== CLIENTES ===");
        System.out.println("Apresentação dos Clientes:");
        cliente1.apresentarSe();
        System.out.println();
        cliente2.apresentarSe();
        System.out.println();
        cliente3.apresentarSe();
        System.out.println();

        System.out.println("=== REMOÇÃO DE VENDEDOR ===");
        System.out.println("Removendo o vendedor João Silva...");
        loja1.removerVendedor(vendedor1);
        System.out.println("Total de vendedores após remoção: " + loja1.contarVendedores());
        System.out.println("Vendedor removido agora está vinculado à loja: " +
                (vendedor1.getLoja() != null ? vendedor1.getLoja().getNomeFantasia() : "Nenhuma"));

    }
}
