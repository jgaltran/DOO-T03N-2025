package objetos;

public class Vendedor extends Pessoa{

    public Vendedor(String nome, Loja loja, int idade, String cidade, String rua, String bairro, double salarioBase) {
        super(nome, loja, idade, cidade, rua, bairro, salarioBase);
    }

    public Vendedor(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
    public double calcularBonus() {
        return super.calcularBonus(0.2f);
    }
}