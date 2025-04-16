package objetosLoja;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import objetosLoja.Loja;

public class Vendedor {
	
	private String nome;
	private int idade;
	private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>(Arrays.asList(2500.50, 2700.0, 2450.75));
    
    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;

    }
    
    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
    }
    
    public double calcularMediaSalarial() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
    
    public double calcularBonus() {
        return salarioBase * 0.2;
    }
    
    
    public String getNome() {
        return nome;

    }

    public Loja getLoja() {
        return loja;
    }



    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(List<Double> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

}
