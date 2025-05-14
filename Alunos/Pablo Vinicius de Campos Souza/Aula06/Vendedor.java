package Aula06;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        if (loja != null) {
            System.out.println("Loja: " + loja.getNomeFantasia());
        }
    }

    public double calcularMedia() {
        return salariosRecebidos.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public List<Double> getSalariosRecebidos() {
        return salariosRecebidos;
    }
}