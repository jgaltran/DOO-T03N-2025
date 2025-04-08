package Alunos.Gabriel.Aula06;

import java.util.ArrayList;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase * 1.1);
        this.salarioRecebido.add(salarioBase * 1.2);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Loja {
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

    public void contarClientes() {
        System.out.println("Total de Clientes: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Total de Vendedores: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}

public class MyPlant {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant Comércio de Plantas Ltda", "12.345.678/0001-90", "São Paulo", "Centro", "Rua das Flores");

        Vendedor vendedor1 = new Vendedor("Gabriel", 30, loja.getNomeFantasia(), "São Paulo", "Centro", "Rua das Flores", 3000);
        Vendedor vendedor2 = new Vendedor("Ana", 28, loja.getNomeFantasia(), "São Paulo", "Centro", "Rua das Flores", 3200);

        Cliente cliente1 = new Cliente("João", 25, "São Paulo", "Centro", "Rua das Flores");
        Cliente cliente2 = new Cliente("Maria", 22, "São Paulo", "Centro", "Rua das Flores");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        
        loja.apresentarse();

       
        for (Vendedor vendedor : loja.getVendedores()) {
            vendedor.apresentarse();
            System.out.println("Média de Salário: " + vendedor.calcularMedia());
            System.out.println("Bônus: " + vendedor.calcularBonus());
            System.out.println();
        }

        
        loja.contarClientes();
        loja.contarVendedores();
    }
}