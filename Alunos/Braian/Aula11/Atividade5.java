import java.util.Arrays;
import java.util.List;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}

public class Atividade5 {
    public static void main(String[] args) {
        // Criar lista de produtos (mesma da Atv4)
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 2500.00),
                new Produto("Mouse", 80.00),
                new Produto("Teclado", 150.00),
                new Produto("Monitor", 900.00)
        );

        // Somar preços dos produtos usando Stream API
        double somaPrecos = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        // Exibir resultado
        System.out.println("Soma dos preços: R$" + somaPrecos);
    }
}
