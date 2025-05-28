package Alunos.Braian.Aula11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade2 {
    public static void main(String[] args) {
        // Criar lista de nomes
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

        // Converter nomes para maiúsculas usando Stream API
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Exibir resultado
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);
    }
}
