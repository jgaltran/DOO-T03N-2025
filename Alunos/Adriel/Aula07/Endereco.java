public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.printf("Endereço: %s, %s - %s, %s. %s%n", 
            rua, numero, bairro, cidade, estado, 
            complemento != null ? "Complemento: " + complemento : "");
    }

    // Getters and setters
    public String getEstado() { return estado; }
    public String getCidade() { return cidade; }
    public String getBairro() { return bairro; }
    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
}