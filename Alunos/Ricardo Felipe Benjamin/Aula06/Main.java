import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        int escolha;
        
        Loja loja = new Loja("My plant", "My plant LTDA", "121886764000189", 
                            "Cascavel", "Centro", "Avenida brasil");

        Cliente cliente1 = new Cliente("Clara", 20, "Cascavel", "Centro", "Rua Bandeirantes");
        Cliente cliente2 = new Cliente("Zeca", 40, "Cascavel", "Cascavel velho", "Rua das Flores");
        loja.adicionaCliente(cliente1);
        loja.adicionaCliente(cliente2);

        
        Vendedor vendedor1 = new Vendedor("Carlos", 30, "My plant", "Cascavel", 
                                        "Cascavel velho", "Rua das flores", 2000.0);
        Vendedor vendedor2 = new Vendedor("Julia", 25, "Flores centro", "Cascavel",
                                         "Centro", "Rua Bandeirantes", 2500.0);
        loja.adicionaVendedor(vendedor1);
        loja.adicionaVendedor(vendedor2);

        vendedor1.salarioRecebido[0] = 1500.0;
        vendedor1.salarioRecebido[1] = 1500.0;
        vendedor1.salarioRecebido[2] = 1900.0;

        vendedor2.salarioRecebido[0] = 2000.0;
        vendedor2.salarioRecebido[1] = 2000.0;
        vendedor2.salarioRecebido[2] = 2100.0;


        do { 
        System.out.println("Menu");
        System.out.println("[1] Mostrar vendedores: ");
        System.out.println("[2] Mostrar clientes: ");
        System.out.println("[3] Mostrar lojas: ");
        System.out.println("[4] Calcular media: ");
        System.out.println("[0] Sair: ");
        option = scan.nextInt(); 
        scan.nextLine(); 
        
        switch(option) {

            case 1:
                for (Vendedor vendedor : loja.vendedores) {
                    vendedor.apresentar();
                }
                break;

            case 2:
                for (Cliente cliente : loja.clientes) {
                    cliente.apresentarse();
                }
                break;

            case 3:
                loja.apresentarse();
                break;

                case 4:
                    System.out.println("VENDEDORES");
                    for (Vendedor vendedor : loja.vendedores) {
                     vendedor.apresentar();
                    }
                    System.out.println("Escola o vendedor [1] ou [2]");
                    escolha = scan.nextInt(); 

                        if(escolha == 1) {
                            System.out.printf("Média Salarial: %.2f\n", vendedor1.calcularMedia());
                            System.out.println("Bônus: " + vendedor1.calcularBonus());

                        } else if(escolha == 2) {
                            System.out.printf("Média Salarial: %.2f\n", vendedor2.calcularMedia());
                            System.out.println("Bônus: " + vendedor2.calcularBonus());
                        }
                    break;

            case 0:
                System.out.println("Saindo...");
                break;

                default:
                    System.out.println("Opção invalido");

        }
        
        } while(option != 0);

    }
    
}
