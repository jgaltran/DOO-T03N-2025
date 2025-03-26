#**Paradigma Imperativo**

O foco está em como um programa deve realizar suas tarefas. Isso envolve a manipulação de estados e a execução de comandos sequenciais. **Linguagens** como ***Java*** são tipicamente **imperativas**, onde o programador especifica uma sequência de instruções que o computador deve seguir.

---

#**Paradigma Declarativo**

O foco está em o que deve ser feito, em vez de como fazê-lo. O programador descreve as propriedades desejadas do resultado, e o sistema é responsável por determinar como alcançá-las. **Prolog** é um exemplo de uma **linguagem declarativa**, onde o programador define fatos e regras, e o sistema realiza a inferência.

---

## **Exemplo Comparativo**

1. **Código declarativo em Prolog**

`soma(0, 0). % Caso base: a soma de 0 é 0
soma(N, S) :- N > 0, N1 is N - 1, soma(N1, S1), S is S1 + N. % Regra recursiva

% Para consultar a soma de 1 a N, você pode usar:
% ?- soma(10, S).`

> **Como funciona**:

- Define-se um fato base que diz que a soma de 0 é 0.
- A regra soma(N, S) define que, se N for maior que 0, a soma de N é a soma de N-1 mais N.
- Para calcular a soma, você faz uma consulta, como soma(10, S), e o Prolog resolve a consulta usando a inferência.

--- 

### **Comparação**

1. **Estrutura de Controle:**

**Java**: 

- Utiliza um loop for para iterar sobre os números, explicitamente controlando o fluxo de execução.

**Prolog**: 

- Utiliza recursão e um acumulador para manter o estado da soma, controlando o fluxo através de chamadas recursivas.

2. **Manipulação de Estado**

**Java**: 

- O estado é manipulado através de variáveis (como soma e i), que são atualizadas em cada iteração do loop

**Prolog**: 

- O estado é mantido através de um acumulador (Acc) que é passado entre as chamadas recursivas.

3. **Abordagem**

**Java**: 

- O programador especifica como a soma deve ser calculada, passo a passo.

**Prolog**: 

- O programador define a lógica de como a soma deve ser realizada, e o sistema se encarrega de executar essa lógica.

4. **Execução**: 

**Java**: 

- O código é executado sequencialmente, seguindo a ordem das instruções.

**Prolog**: 

- A execução é baseada em chamadas recursivas, onde o sistema resolve a consulta de acordo com as regras definidas.

--- 

## Exemplo de Código Imperativo em Java

`import java.util.stream.IntStream;

public class SomaDeclarativa {
    public static void main(String[] args) {
        int N = 10; // Definindo o valor de N
        int soma = IntStream.rangeClosed(1, N) // Cria um stream de números de 1 a N
                            .sum(); // Calcula a soma

        System.out.println("A soma de 1 a " + N + " é: " + soma); // Exibe o resultado
    }
}`

Em Java, podemos usar a API de Streams para criar um código que calcula a soma dos números de 1 a N de forma declarativa.

> **Como funciona**:

- O código define um valor para N.
- Utiliza IntStream.rangeClosed(1, N) para criar um fluxo de números de 1 a N.
- O método sum() é chamado no fluxo para calcular a soma de todos os números.
- Por fim, imprime o resultado.

--- 

### Comparação

1. **Abordagem**:

- **Java**: O código é escrito de forma declarativa usando a API de Streams, onde o programador especifica o que deseja (a soma dos números) sem se preocupar com o controle de fluxo detalhado.

- **Prolog**: O programador define a lógica de como a soma deve ser realizada através de regras e fatos, e o sistema se encarrega de resolver a consulta.

2. **Manipulação de Estado**:

- **Java**: O estado é gerenciado implicitamente pelo fluxo de dados no Stream, sem a necessidade de variáveis mutáveis.

- **Prolog**: O estado é mantido através de recursão e variáveis que são unificadas durante a execução.

3. **Execução**: 

- **Java**: O código é executado de forma declarativa, onde a operação de soma é aplicada a um conjunto de dados (o Stream).

- **Prolog**: A execução é baseada em inferência, onde o Prolog busca satisfazer a consulta com base nas regras definidas.

4. **Legibilidade e Manutenção**:

- **Java**: O uso de Streams torna o código mais conciso e legível, permitindo que o programador se concentre no que deseja fazer, em vez de como fazê-lo.

- **Prolog**: A lógica declarativa permite que o programador defina claramente as relações e regras, tornando o código fácil de entender em termos de lógica.
