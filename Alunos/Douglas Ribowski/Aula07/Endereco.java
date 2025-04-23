package fag;

public class Endereco {
    private String estado, cidade, bairro, numero, complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String apresentarLogradouro() {
        return bairro + ", Nº: " + numero + " - " + complemento + ", " + cidade + ", " + estado;
    }
}