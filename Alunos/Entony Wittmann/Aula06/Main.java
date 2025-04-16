import java.util.Scanner;

public class Main {
    static Loja loja = new Loja("MyPlant", "MyPlant Ltda", "00.111.222/0001-33", "Cascavel", "Centro", "Av. das Flores");
    static Vendedor vendedor1 = new Vendedor("Juninho", 18, "MyPlant", "Cascavel", "Centro", "Rua A", 2500.0);
    static Cliente cliente1 = new Cliente("Paula", 25, "Cascavel", "Jardins", "Rua B");
    public static void main(String[] args) {
        loja.adicionaVendedor(vendedor1);
        loja.adicionaCliente(cliente1);

        menu();
    }
    public static void menu() {

        System.out.println("Seja bem vindo! Escolha a opção que deseja!");
        System.out.println("1 - Apresentação do Vendedor.\n2 - Apresentação do cliente.\n3 - Apresentar a Loja.\n4 - Sair.");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println("Apresentação do Vendedor:");
                vendedor1.apresentarse();
                System.out.println("Média salarial: " + vendedor1.calcularMedia());
                System.out.println("Bônus: " + vendedor1.calcularBonus());
                menu();
                break;
                case 2:
                    System.out.println("\nApresentação do Cliente:");
                    cliente1.apresentarse();
                    menu();
                    break;
                    case 3:
                        System.out.println("\nApresentação da Loja:");
                        loja.apresentarse();

                        System.out.println("\nTotal de clientes: " + loja.contarClientes());
                        System.out.println("Total de vendedores: " + loja.contarVendedores());
                        menu();
                        break;
                        case 4:
                            break;
        }
    }
}