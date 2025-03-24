import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, Integer> registroPlantas = new HashMap<String, Integer>();

    public static void main(String[] args) {
        menu();


    }

    static void menu() {
        int escolha = 0;
        while (escolha != 4) {
            System.out.println("[1] - Comprar/calcular preço \n" + "[2] - Calcular Troco \n" + "[3] - Vendas  \n" + "[4] - Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    total();
                    break;
                case 2:
                    troco();
                    break;
                case 3:
                    vendas();
                    break;
                case 4:
                    System.out.println("Ate mais!!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.  \n ");
                    break;
            }
        }
    }


    public static void total() {

        int quantidade = 0;
        float temp = 0;
        float valorTotal = 0;

        System.out.println("Calculadora de preços \n" + "Digite a Quantidade de plantas que você irá comprar:");
        quantidade = scanner.nextInt();
        System.out.println("Digite o valor unitario de cada planta:");
        float valor = scanner.nextFloat();

        System.out.println("Informe o dia (DD) da compra: ");
        String dia = scanner.next();
        System.out.println("Informe o mês (MM) da compra: ");
        String mes = scanner.next();

        String chave = mes + "-" + dia;
        registroPlantas.put(chave, registroPlantas.getOrDefault(chave, 0) + quantidade);
        registroPlantas.put(chave, (int) (registroPlantas.getOrDefault(chave, 0) + valorTotal));

        float valorBruto = valor * quantidade;
        valorTotal = valorBruto;

        if (quantidade > 10) {
            temp = (valorBruto * 5) / 100;
            valorTotal = valorBruto - temp;
            System.out.println("Você comprou mais de 10 unidades então ganhara 5% de desconto o valor ficou R$: " + valorTotal);
        } else {
            System.out.println("O valor total da compra foi de R$: " + valorBruto);
        }


        System.out.println("Vendas registradas com sucesso!");
    }

    public static void troco() {
        System.out.println("Calculadora de trocos \n " + "Digite o valor recebido do cliente:");
        float Dcliente = scanner.nextFloat();
        System.out.println("Digite o valor da compra do cliente:");
        float valorCompra = scanner.nextFloat();

        float troco = Dcliente - valorCompra;

        System.out.println("O troco serÁ de R$: " + troco);

    }

    public static void vendas() {
        int cont = 1;

        System.out.println("Informe o mês (MM) da compra: ");
        String mes = scanner.next();
        System.out.println("Informe o dia (DD) da compra: ");
        String dia = scanner.next();
        String chave = mes + "-" + dia;
        int quantidade = registroPlantas.getOrDefault(chave, 0);

        System.out.println("Total de vendas no dia " + dia + "/" + mes + ": " + quantidade + " plantas ");
    }

}