package Alunos.Gabriel.Aula07;

class Gerente{
    private String nome;
    private Integer idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salariobase;
    private Double salariorecebido[];

    public Gerente(String nome, Integer idade, String loja, String cidade, String bairro, String rua, Double salariobase, Double salariorecebido){
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salariobase = salariobase;
        this.salariorecebido = new Double[]{1500.00, 2000.00, 2500.00};

    }
    public String getNome(){
        return nome;
    }
    public Integer getIdade(){
        return idade;
    }
    public String getLoja(){
        return loja;
    }
    public String getcidade(){
        return cidade;
    }
    public String getbairro(){
        return bairro;
    }
    public String getrua(){
        return rua;
    }
    public Double getSalarioBase(){
        return salariobase;
    }
    public Double[] getSalariorecebido(){
        return salariorecebido;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setIdade(Integer idade){
        this.idade = idade;
    }
    public void setLoja(String loja){
        this.loja = loja;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    public void setSalarioBase(Double salariobase){
        this.salariobase = salariobase;
    }
    public void setSalariorecebido(Double[] salariorecebido){
        this.salariorecebido = salariorecebido;
    }
    @Override
    public String toString() {
        
        return super.toString() + "\nNome: " + nome + "\nIdade: " + idade + "\nLoja: " + loja + "\nCidade: " + cidade + "\nBairro: " + bairro + "\nRua: " + rua + "\nSalario Base: " + salariobase + "\nSalario Recebido: " + salariorecebido[0] + ", " + salariorecebido[1] + ", " + salariorecebido[2];
    }

    public void apresentarse(){
        System.out.println("nome: "+ this.nome);
        System.out.println("nome: "+ this.idade);
        System.out.println("nome: "+ this.loja);
    }
    public void calcularmedia(){
        double media = (this.salariorecebido[0] + this.salariorecebido[1] + this.salariorecebido[2]) / 3;
        System.out.println("A media dos salarios recebidos é: " + media);
    }
    public void calcularbonus(){
        System.out.println("O bonus é: " + (this.salariobase * 0.35));

    }
    
}
