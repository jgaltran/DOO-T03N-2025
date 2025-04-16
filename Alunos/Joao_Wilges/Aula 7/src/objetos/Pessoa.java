package objetos;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase = 0;
    private double salarioRecebido1 = 0;
    private double salarioRecebido2 = 0;
    private double salarioRecebido3 = 0;
    private int qtd_salario = 3;
    private int contador_salario = 0;
    public Pessoa(String nome, int idade, String cidade, String rua, String bairro) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }
}