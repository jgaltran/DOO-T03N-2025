package Alunos.Braian.Aula07;


 class Gerente{
    private String nome;
    private Integer idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private Double salarioRecebido [];

    public Gerente(String nome, Integer idade, String loja, String cidade, String bairro, String rua, Double salarioBase, Double salarioRecebido){
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new Double[]{1780.00, 1810.00, 1850.00};
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
          public String getCidade(){
            return cidade;
          }
          public String getBairro(){
            return bairro;
          }
          public String getRua(){
            return rua;
          }
          public Double getSalarioBase(){
            return salarioBase;
          }
          public Double[] salarioRecebido(){
            return salarioRecebido;
          }
          public void setNome(String nome){
            this.nome = nome;
          }
          public void setIdade(int idade){
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
        public void setSalarioBase(Double salarioBase){
            this.salarioBase = salarioBase;
          }
          public void setSalarioRecebido(Double[] salarioRecebido){
            this.salarioRecebido = salarioRecebido;
          }

    @Override
    public String toString(){
    return "Gerente [nome=" + nome + ", idade=" + idade + ", loja=" 
    + loja + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua +
     ", salarioBase=" + salarioBase + ", salarioRecebido=" + salarioRecebido[0] +
      ", " + salarioRecebido[1] + ", " + salarioRecebido[2] + "]";    
    }
    
    public void apresentarSe(){
    System.out.println("O nome é: " + this.nome);
    System.out.println("A idade é: " + this.idade);
    System.out.println("A loja é: " + this.loja);    
    }
    public void calcularMedia(){
    Double media = (this.salarioRecebido[0] + this.salarioRecebido[1] + this.salarioRecebido[2]) / 3;
    System.out.println("A média dos salários é: " + media);
    }
    public void calcularBonus(){
        System.out.println("O bônus é: " + this.salarioBase * 0.35);
    }
 }
