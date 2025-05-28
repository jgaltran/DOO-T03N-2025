package Alunos.Braian.Aula11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade6 {
    public static void main(String[] args) {
        // Criar lista de linguagens
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        // Ordenar por tamanho da palavra usando Stream API
        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        // Exibir resultado
        System.out.println("Linguagens ordenadas por tamanho: " + linguagensOrdenadas);
    }
}
