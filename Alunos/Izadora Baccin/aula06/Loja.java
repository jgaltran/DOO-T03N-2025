package fag;

import java.util.List;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    List<Vendedor> vendedores;
    List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua,
                List<Vendedor> vendedores, List<Cliente> clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void apresentarSe() {
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }
}

