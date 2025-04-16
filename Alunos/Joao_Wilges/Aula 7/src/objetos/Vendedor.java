package objetos;

public class Vendedor extends Funcionario{

    public Vendedor(String nome, Loja loja, int idade, String cidade, String rua, String bairro, double salarioBase) {
        super(nome, loja, idade, cidade, rua, bairro, salarioBase);
    }
    public double calcularBonus() {
        return super.calcularBonus(0.2f);
    }
}