import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade1 {
    public static void main(String[] args) {
        // Criar uma lista com 10 números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtrar apenas os números pares usando Stream API
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Exibir resultado
        System.out.println("Números pares: " + pares);
    }
}
