# Paradigmas de Programação: Imperativo e Declarativo

Na aula teórica do dia 25/03/2025, foram abordados dois paradigmas fundamentais da programação: **imperativo** e **declarativo**. Ambos são estilos de programação que influenciam diretamente na forma como os programas são escritos, compreendidos e mantidos.

## Paradigma Imperativo

O paradigma imperativo se baseia em **comandos sequenciais que modificam o estado do programa**. O programador descreve detalhadamente os **passos necessários** para alcançar um resultado. Linguagens como Java, C e Python (em muitos casos) seguem essa abordagem. Nesse paradigma, o foco está em **"como fazer"**.

### Exemplo em Java:
```java
public class Soma {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int resultado = a + b;
        System.out.println("Resultado: " + resultado);
    }
}