public class Vendedor{
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private Double salarioRecebido[];

    public Vendedor(){
        
    }

   
    
    public Vendedor(String nome, int idade, String loja, Double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new Double[]{1500.00, 2000.00, 2500.00};
    }        

    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public int getidade(){
        return idade;
    }
    public void setidade(int idade){
        this.idade = idade;
    }
    public String getloja(){
        return loja;
    }
    public void setloja(String loja){
        this.loja = loja;
    }
    public String getcidade(){
        return cidade;
    }
    public void setcidade(String cidade){
        this.cidade = cidade;
    }
    public String getbairro(){
        return bairro;
    }
    public void setbairro(String bairro){
        this.bairro = bairro;
    }
    public String getrua(){
        return rua;
    }
    public void setrua(String rua){
        this.rua = rua;
    }
    public Double getsalarioBase(){
        return salarioBase;
    }
    public void setsalarioBase(Double salarioBase){
        this.salarioBase = salarioBase;
    }
    public Double[] getsalarioRecebido(){
        return salarioRecebido;
    }
    public void setsalarioRecebido(Double[] salarioRecebido){
        this.salarioRecebido = salarioRecebido;
    }

    public void identificarse(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }
    public void mediaSalario(){
        Double media = (this.salarioRecebido[0] + this.salarioRecebido[1] + this.salarioRecebido[2]) / 3;
        System.out.println("A média de salário é: " + media);
    }
    public void bonus(){
        System.out.println("bônus:"+ (this.salarioBase * 0.2));
    }
}
