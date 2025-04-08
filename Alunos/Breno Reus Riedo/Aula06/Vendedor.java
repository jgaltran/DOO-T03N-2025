import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;
    private BigDecimal salarioBase;
    private List<BigDecimal> salarioRecebido;


    public Vendedor(String nome, int idade, String cidade, String bairro, String rua, BigDecimal salarioBase, List<BigDecimal> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<BigDecimal> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(List<BigDecimal> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public BigDecimal calcularMedia(){
        BigDecimal media = BigDecimal.ZERO;

        for (BigDecimal valor : salarioRecebido){
            media = media.add(valor);
        }

        return media.divide(new BigDecimal(salarioRecebido.size()), RoundingMode.HALF_UP);
    }

    public BigDecimal calcularBonus(){
        return salarioBase.multiply(new BigDecimal("0.2"));
    }

    //TODO
    public void apresentarSe(){

    }

}
