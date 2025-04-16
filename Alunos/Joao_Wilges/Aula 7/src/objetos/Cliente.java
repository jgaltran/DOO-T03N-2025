package objetos;

public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        super(nome, idade, cidade, rua, bairro);
    }
    public void apresentarse() {
        System.out.println("Nome: " + super.getNome());
        System.out.println("Idade: " + super.getIdade());
    }
    public String getNome() {
        return super.getNome();
    }
}
