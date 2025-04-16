package objetos;

public class Gerente extends Pessoa{

    public Gerente(String nome, Loja loja, int idade, String cidade, String rua, String bairro, double salarioBase) {
        super(nome, loja, idade, cidade, rua, bairro, salarioBase);
    }

    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    public double calcularBonus() {
        return super.calcularBonus(0.35f);
    }

}
