# Paradigmas de Programação: Imperativo vs. Declarativo

Os paradigmas de programação podem ser classificados de diversas maneiras, sendo os mais conhecidos o **imperativo** e o **declarativo**. Esses paradigmas possuem abordagens distintas para resolver problemas e construir soluções, e sua diferença se reflete diretamente na forma como o código é escrito e executado.

## Paradigma Imperativo

No paradigma imperativo, o foco está em **como** realizar uma tarefa. O programador descreve explicitamente o conjunto de operações e instruções que o computador deve seguir para atingir o resultado desejado. O código é sequencial, e as variáveis têm estados mutáveis, ou seja, elas podem ser alteradas durante a execução do programa. Linguagens como **Java**, **C**, **Python** e **C++** seguem esse paradigma.

Um programa imperativo é como uma receita de culinária: você lista os passos exatos a serem seguidos para alcançar o objetivo. Cada operação tem impacto direto no estado do sistema, e o fluxo de controle é detalhado.

## Paradigma Declarativo

O paradigma declarativo, por outro lado, preocupa-se **com o que** deve ser alcançado, ao invés de se concentrar em como isso será feito. O programador descreve o resultado desejado e deixa para o sistema decidir a melhor forma de alcançar esse objetivo. Linguagens como **Prolog**, **SQL** e **HTML** são exemplos típicos de linguagens declarativas. 

No paradigma declarativo, o programador não se preocupa com o controle do fluxo ou com detalhes sobre como os dados serão manipulados. O foco é na descrição do problema de forma mais abstrata.

---

## Comparação de Códigos: Java (Imperativo) vs. Prolog (Declarativo)

### Exemplo em Java (Imperativo)

```java
public class Fatorial {
    public static int fatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(fatorial(5)); // Saída: 120
    }
}
```

### Como funciona?
- O código Java segue o paradigma imperativo ao descrever passo a passo como calcular o fatorial de um número. 
- O programa inicializa uma variável `resultado` com o valor 1 e, em seguida, itera de 1 até `n`, multiplicando o valor atual de `resultado` pelo índice `i` a cada iteração.
- O fluxo de execução é claro e controlado, e o programador tem o controle total do processo de cálculo do fatorial.

### Exemplo em Prolog (Declarativo)

```prolog
fatorial(0, 1).
fatorial(N, F) :- N > 0, N1 is N - 1, fatorial(N1, F1), F is N * F1.

?- fatorial(5, F).
```

### Como funciona?
- O código Prolog descreve o problema de forma declarativa. A primeira linha define a base do cálculo (fatorial de 0 é 1). A segunda linha define a regra recursiva para o fatorial de números maiores que 0.
- Quando a consulta `fatorial(5, F)` é feita, o sistema tenta resolver o problema utilizando as regras definidas. Não há controle explícito do fluxo de execução; o próprio Prolog decide como resolver a recursão para calcular o fatorial.
- A solução é encontrada de forma automática, com o Prolog explorando a base de dados e aplicando as regras até alcançar o valor correto.

---

## Conclusão

Enquanto o código em Java detalha claramente os passos necessários para calcular o fatorial e segue uma estrutura sequencial, o código em Prolog apenas descreve as condições e regras para o cálculo, deixando para o sistema a responsabilidade de encontrar a solução. O **paradigma imperativo** exige que o programador controle o fluxo de execução, enquanto o **paradigma declarativo** permite que o sistema determine a melhor maneira de resolver o problema, tornando o código mais abstrato e conciso.

Essa comparação ilustra como ambos os paradigmas atingem o mesmo objetivo, mas de maneiras fundamentalmente diferentes: o primeiro com instruções detalhadas e o segundo com uma abordagem mais expressiva e de alto nível.
