import java.util.ArrayList;
import java.util.List;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void adicionarSalario(double salario) {
        if (salarioRecebido.size() < 3) {
            salarioRecebido.add(salario);
        } else {
            System.out.println("Não é possível adicionar mais de 3 salários.");
        }
    }

    public void apresentarse() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  Vendedor: " + nome);
        System.out.println("  Idade: " + idade);
        System.out.println("  Loja: " + loja);
        System.out.println("--------------------------------------------------");
    }

    public double calcularMedia() {
        if (salarioRecebido.isEmpty()) return 0;
        double soma = 0;
        for (Double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
