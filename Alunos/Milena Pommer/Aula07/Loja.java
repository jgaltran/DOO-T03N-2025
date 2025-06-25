package objetosMyPlant;

import java.util.ArrayList;
import java.util.List;

public class Loja {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private Endereco endereco;
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	private List<Gerente> gerentes;

	public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.vendedores = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.gerentes = new ArrayList<>();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Gerente> getGerentes() {
		return gerentes;
	}

	public void adicionarVendedor(Vendedor vendedor) {
		this.vendedores.add(vendedor);
	}

	public void adicionarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public void adicionarGerente(Gerente gerente) {
		this.gerentes.add(gerente);
	}

	public int contarClientes() {
		return clientes.size();
	}

	public int contarVendedores() {
		return vendedores.size();
	}

	public int contarGerentes() {
		return gerentes.size();
	}

	public void apresentarSe() {
		System.out.println("\nLoja: " + nomeFantasia + " ---");
		System.out.println("Razão Social: " + razaoSocial);
		System.out.println("CNPJ: " + cnpj);
		endereco.apresentarLogradouro();
	}
}
