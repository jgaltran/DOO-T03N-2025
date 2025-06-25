package objetos;

import java.util.ArrayList;


public class Loja {

	 private String nomeFantasia;
	    private String razaoSocial;
	    private String cnpj;
	    private String cidade;
	    private String bairro;
	    private String rua;
	    private ArrayList<Vendedor> vendedores = new ArrayList<>();
	    private ArrayList<Cliente> clientes = new ArrayList<>();

	    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
	        this.nomeFantasia = nomeFantasia;
	        this.razaoSocial = razaoSocial;
	        this.cnpj = cnpj;
	        this.cidade = cidade;
	        this.bairro = bairro;
	        this.rua = rua;
	    }
	    
	    public ArrayList<Vendedor> getVendedores() {
	        return vendedores;
	    }
	    
	    public String getNomeFantasia() {
	        return nomeFantasia;
	    }

	    public void adicionaVendedor(Vendedor vendedor) {
	        vendedores.add(vendedor);
	    }

	    public void adicionaCliente(Cliente cliente) {
	        clientes.add(cliente);
	    }

	    public int contarClientes() {
	        return clientes.size();
	    }

	    public int contarVendedores() {
	        return vendedores.size();
	    }

	    public void apresentarse() {
	        System.out.printf("Nome Fantasia: %s | CNPJ: %s | Endereço: %s, %s - %s\n",
	                nomeFantasia, cnpj, rua, bairro, cidade);
	    }
	}