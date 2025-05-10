package Objetos;

public class Loja {
    public String nomeFantasia;
    public String razaoSocial;
    public String cnpj;
    public String cidade;
    public String bairro;
    public String rua;
    public Vendedor[] vendedores;
    public Cliente[] clientes;
    public int contadorVendedores;
    public int contadorClientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String
            bairro, String rua, int capacidadeVendedores, int capacidadeClientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new Vendedor[capacidadeVendedores];
        this.clientes = new Cliente[capacidadeClientes];
        this.contadorVendedores = 0;
        this.contadorClientes = 0;
    }

    public void adicionarVendedor(Vendedor vendedor) {
        if (this.contadorVendedores < this.vendedores.length) {
            this.vendedores[this.contadorVendedores++] = vendedor;
        }

    }

    public void adicionarCliente(Cliente cliente) {
        if (this.contadorClientes < this.clientes.length) {
            this.clientes[this.contadorClientes++] = cliente;
        }

    }

    public int contarClientes() {
        return this.contadorClientes;
    }

    public int contarVendedores() {
        return this.contadorVendedores;
    }

    public void apresentarLoja() {
        System.out.println("\n Loja: " + this.nomeFantasia + ", CNPJ: " + this.cnpj +
                ", Endereço: " + this.rua + ", " + this.bairro + ", " + this.cidade);
    }
}