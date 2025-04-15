# Paradigmas de Programação: Imperativo vs Declarativo

Durante a aula do dia 25/03/2025, foram discutidos dois paradigmas fundamentais da programação: o **paradigma imperativo** e o **paradigma declarativo**. A principal diferença entre eles está na forma como o programador expressa a lógica de um algoritmo.

## Paradigma Imperativo

O paradigma imperativo se baseia em **comandos sequenciais**, onde o programador descreve **passo a passo** como o programa deve atingir um objetivo. Linguagens como **Java, C e Python** utilizam majoritariamente esse paradigma.

### Exemplo em Java:

```java
public class Soma {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int resultado = a + b;
        System.out.println("Resultado: " + resultado);
    }
}
