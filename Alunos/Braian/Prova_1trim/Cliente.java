package Alunos.Braian.Prova_1trim;

public class Cliente {
    public String nomeCliente;
    public Integer idadeCliente;
    public String cidadeCliente;
    public String bairroCliente;
    public String ruaCliente;
    public boolean temEmprestimo;

    public Cliente(String nomeCliente, Integer idadeCliente, String cidadeCliente, String bairroCliente, String ruaCliente) {
        this.nomeCliente = nomeCliente;
        this.idadeCliente = idadeCliente;
        this.cidadeCliente = cidadeCliente;
        this.bairroCliente = bairroCliente;
        this.ruaCliente = ruaCliente;
        this.temEmprestimo = false; // Inicialmente o cliente não tem empréstimos pendentes
    }

    // Getters e Setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isTemEmprestimo() {
        return temEmprestimo;
    }

    public void setTemEmprestimo(boolean temEmprestimo) {
        this.temEmprestimo = temEmprestimo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente;
    }
}
