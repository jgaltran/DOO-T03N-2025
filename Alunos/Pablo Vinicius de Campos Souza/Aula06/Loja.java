package Aula06;

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public int contarClientes() {
        return clientes != null ? clientes.size() : 0;
    }

    public int contarVendedores() {
        return vendedores != null ? vendedores.size() : 0;
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.printf("Endereço: %s, %s, %s%n", rua, bairro, cidade);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        if (!vendedores.contains(vendedor)) {
            vendedores.add(vendedor);
            vendedor.setLoja(this);
        }
    }

    public void removerVendedor(Vendedor vendedor) {
        if (vendedores.remove(vendedor)) {
            vendedor.setLoja(null);
        }
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}