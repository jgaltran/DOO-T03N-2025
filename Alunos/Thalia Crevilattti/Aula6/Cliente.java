// classe cliente

public class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }
   
    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(
            "Ana Maria",
            25,
            "São Paulo",
            "Centro",
            "Av. Principal"
        );

        cliente1.apresentarse();
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
