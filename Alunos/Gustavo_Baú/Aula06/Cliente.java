package Alunos.Gustavo_Baú.Aula06;

public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarSe() {
        System.out.printf("Meu nome é %s e tenho %d anos.%n", nome, idade);
    }
}