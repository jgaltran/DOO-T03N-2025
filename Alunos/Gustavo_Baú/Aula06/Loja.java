package Alunos.Gustavo_Baú.Aula06;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String cnpj;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Loja(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void apresentarSe() {
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
    }
}