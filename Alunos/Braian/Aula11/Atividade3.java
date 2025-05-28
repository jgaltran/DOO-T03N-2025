import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade3 {
    public static void main(String[] args) {
        // Criar lista de palavras
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        // Contar frequência de cada palavra usando Stream API
        Map<String, Long> contagemPalavras = palavras.stream()
                .collect(Collectors.groupingBy(
                        String::toString,
                        Collectors.counting()
                ));

        // Exibir resultado
        System.out.println("Contagem de palavras: " + contagemPalavras);
    }
}
