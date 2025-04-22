package fag;

import java.util.*;

public class Loja {
    private String nomeFantasia, razaoSocial, cnpj;
    public Endereco endereco;
    public List<Vendedor> vendedores;
    public List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionaVendedor(Vendedor v) {
        vendedores.add(v);
    }

    public void adicionaCliente(Cliente c) {
        clientes.add(c);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println(nomeFantasia + " | CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}