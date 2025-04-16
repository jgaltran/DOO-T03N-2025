import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    float salarioBase;
    List<Float> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, float salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;

        salarioRecebido.add(2000f);
        salarioRecebido.add(2100f);
        salarioRecebido.add(2200f);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public void calcularMedia() {
        float soma = 0;
        for (float salario : salarioRecebido) {
            soma += salario;
        }
        System.out.println("Média salarial: " + (soma / salarioRecebido.size()));
    }

    public void calcularBonus() {
        System.out.println("Bônus: " + (salarioBase * 0.2));
    }
}
