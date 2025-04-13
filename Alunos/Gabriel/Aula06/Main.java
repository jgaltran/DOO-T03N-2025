
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vendedor vendedor1 = new Vendedor("Lucas", 25, "Loja A",2000.00); 
        Cliente cliente1 = new Cliente("Ana", 30);
        Loja statusloja = new Loja("My Plant", 123456,
         "Cascavel", "Centro", "Av.Brasil");
        statusloja.adicionarVendedor(vendedor1);
        statusloja.adicionarCliente(cliente1);
        
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Ver status do vendedor");
            System.out.println("2. Ver status do cliente");
            System.out.println("3. Ver status da loja");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1 ->{
                    vendedor1.identificarse();
                    vendedor1.mediaSalario();
                    vendedor1.bonus();
                }
                case 2 -> {
                    cliente1.apresentar();
                }
                case 3 ->{
                    statusloja.contarclientes();
                    statusloja.contarvendedores();
                    statusloja.locLoja();
                }
                case 4 -> {
                    System.out.println("Obrigado por testar!!!");
                    scanner.close();
                    return;
                }
                default->{
                    System.out.println("Algo deu errado!!!");
                }
            }
            
        }
        
    }
    
}