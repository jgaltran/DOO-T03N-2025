package Alunos.Gustavo_Baú.Aula06;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase * 1.05);
        this.salarioRecebido.add(salarioBase * 0.98);
    }

    public void apresentarSe() {
        System.out.printf("Meu nome é %s, tenho %d anos e trabalho na %s.%n", nome, idade, loja.getNomeFantasia());
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}