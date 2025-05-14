
import java.util.ArrayList;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente>  clientes;

    public Loja(){

    }
    public Loja (String nomeFantasia, int cnpj, String cidade, String bairro, String rua){
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>(); 
        this.clientes = new ArrayList<>();
    }
    public Loja(String nomeFantasia, String razaoSocial,
     int cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>(); 
        this.clientes = new ArrayList<>(); 
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public int getCnpj() {
        return cnpj;
    }
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }
    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
   
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
    public void contarclientes(){
        System.out.println("Total de clientes: "+clientes.size());
    }
    public void contarvendedores(){
        System.out.println("Total de vendedores: "+vendedores.size());
    }
    public void locLoja(){
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
    }
}

