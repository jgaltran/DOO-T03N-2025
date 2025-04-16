package objetos;

import objetos.managers.ClienteManager;
import objetos.managers.VendedorManager;

public class Loja {
    private String nome;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private VendedorManager vendedorManager;
    private ClienteManager clienteManager;

    public Loja(String nome, String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedorManager = new VendedorManager();
        this.clienteManager = new ClienteManager();
    }

    public int contarVendedores() {
        return vendedorManager.contarVendedores();
    }

    public int contarClientes() {
        return clienteManager.contarClientes();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void cadastrarVendedor(String nome, int idade, String cidade, String rua, String bairro, String complemento, String numero, double salarioBase) {
        vendedorManager.cadastrarVendedor(nome, this, idade, cidade, rua, bairro, complemento, numero, salarioBase);
    }

    public void excluirVendedor(String nome) {
        vendedorManager.excluirVendedor(nome);
    }

    public void cadastrarCliente(String nome, int idade, String cidade, String bairro, String rua, String complemento, String numero) {
        clienteManager.cadastrarCliente(nome, idade, cidade, bairro, rua, complemento, numero);
    }

    public void excluirCliente(String nome) {
        clienteManager.excluirCliente(nome);
    }

    public void cadastrarVendedor(String nome, Loja loja, int idade, String cidade, String rua, String bairro, String complemento, String numero, double salarioBase) {
    }
}
