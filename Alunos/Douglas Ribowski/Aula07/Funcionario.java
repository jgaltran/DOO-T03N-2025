package fag;

import java.util.*;

public abstract class Funcionario extends Pessoa {
    protected Loja loja;
    protected double salarioBase;
    protected List<Double> salarioRecebido;

    public Funcionario(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(salarioBase, salarioBase + 200, salarioBase - 150);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public abstract double calcularBonus();

    @Override
    public void apresentarse() {
        System.out.println(nome + " (" + idade + ") - Loja: " + loja.getNomeFantasia());
    }
}