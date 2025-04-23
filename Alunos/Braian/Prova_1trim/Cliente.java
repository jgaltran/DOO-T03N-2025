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
        this.temEmprestimo = false;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isTemEmprestimo() {
        return temEmprestimo;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(Integer idadeCliente) {
        this.idadeCliente = idadeCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public void setTemEmprestimo(boolean temEmprestimo) {
        this.temEmprestimo = temEmprestimo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente;
    }
}
