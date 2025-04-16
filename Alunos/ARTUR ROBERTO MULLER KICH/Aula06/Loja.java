public class Loja {
    String nomeFantasia;
    String cnpj;
    Vendedor[] vendedores;
    Cliente[] clientes;

    public Loja(String nomeFantasia, String cnpj, Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
    }

    public void contarClientes() {
        System.out.println("Quantidade de clientes: " + clientes.length);
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores: " + vendedores.length);
    }
}
