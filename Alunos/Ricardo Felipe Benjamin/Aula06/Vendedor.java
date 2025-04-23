public class Vendedor {

    public String nome;
    public Integer idade;
    public String loja;
    public String cidade;
    public String bairro;
    public String rua;
    public Double salarioBase;
    public Double[] salarioRecebido =  new Double [3];

    public Vendedor(String nome, Integer idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;

    } 

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja + "\n");
    }

    public double calcularMedia() {
        double soma = 0;
        
        for (Double salario : salarioRecebido) {
             soma += salario;
        }
         double media = soma / salarioRecebido.length;

         return media;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
   
}