import java.util.ArrayList;
import java.util.List;

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

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

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void contarClientes() {
        System.out.println("Quantidade de clientes cadastrados: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores cadastrados: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("\n********** DADOS DA LOJA **********");
        System.out.println("  Nome Fantasia: " + nomeFantasia);
        System.out.println("  Razão Social: " + razaoSocial);
        System.out.println("  CNPJ: " + cnpj);
        System.out.println("  Endereço: " + rua + ", " + bairro + ", " + cidade);
        System.out.println("************************************");
    }
}
