package objetos;


import java.util.ArrayList;

public class Vendedor {

	  private String nome;
	    private int idade;
	    private String loja;
	    private String cidade;
	    private String bairro;
	    private String rua;
	    private double salarioBase;
	    private ArrayList<Double> salarioRecebido = new ArrayList<>();

	    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
	        this.nome = nome;
	        this.idade = idade;
	        this.loja = loja;
	        this.cidade = cidade;
	        this.bairro = bairro;
	        this.rua = rua;
	        this.salarioBase = salarioBase;
	    }

	    public void adicionarSalario(double valor) {
	        if (salarioRecebido.size() < 3) { 
	            salarioRecebido.add(valor);
	        }
	    }

	    public void apresentarse() {
	        System.out.printf("Nome: %s | Idade: %d | Loja: %s\n", nome, idade, loja);
	    }

	    public double calcularMedia() {
	        if (salarioRecebido.isEmpty()) return 0;

	        double soma = 0;
	        for (double salario : salarioRecebido) {
	            soma += salario;
	        }
	        return soma / salarioRecebido.size();
	    }

	    public double calcularBonus() {
	        return salarioBase * 0.2;
	    }
}