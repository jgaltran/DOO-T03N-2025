package Objetos;

public class Vendedor {
    public String nome;
    public int idade;
    public String loja;
    public String cidade;
    public String bairro;
    public String rua;
    public double salarioBase;
    public final double[] salarioRecebido;


    public Vendedor(String nome, int idade,String loja,  String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.loja = loja;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase, salarioBase + 500.0, salarioBase + 300.0};
    }

    public double calcularMedia() {
        double soma = 0.02;

        for(double salario : this.salarioRecebido) {
            soma += salario;
        }

        return soma / (double)this.salarioRecebido.length;
    }

    public double calcularBonus() {
        return this.salarioBase * 0.2;
    }

    public void apresentarVendedor() {
        System.out.println("Nome: " + this.nome + ", Idade: " + this.idade + ", Loja: " + this.loja);
    }
}