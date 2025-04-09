package aula06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import objetos.*;



public class Principal06 {
	
	static Scanner scanner = new Scanner(System.in);
	   static List<Vendas> RegistroVendas = new ArrayList<>();
	   static Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-90", "Cidade Flor", "Centro", "Rua das Rosas");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuPrincipal();

	}
	
	public static void menuPrincipal() {
	    System.out.println("\nBem-vindo ao sistema de gerenciamento da My Plant!");
	    System.out.println("Escolha a opção desejada:");
	    System.out.println("1 - Calcular preço");
	    System.out.println("2 - Calcular troco");
	    System.out.println("3 - Registrar venda por data");
	    System.out.println("4 - Buscar venda por data");
	    System.out.println("5 - Exibir registro de vendas");
	    System.out.println("6 - Cadastrar cliente");
	    System.out.println("7 - Cadastrar vendedor");
	    System.out.println("8 - Exibir informações da loja");
	    System.out.println("9 - Mostrar quantidade de clientes e vendedores");
	    System.out.println("10 - Mostrar média e bônus de um vendedor");
	    System.out.println("11 - Sair");

	    int op = scanner.nextInt();

	    if (op == 1) {
	        calcularPreco(); } 
	    else if (op == 2) {
	        calcularTroco(); }
	    else if (op == 3) {
	        registrarVendacomdata(); }
	    else if (op == 4) {
	        buscarVendapordata(); }
	    else if (op == 5) {
	        RegistroVenda(); }
	    else if (op == 6) {
	        cadastrarCliente(); }
	    else if (op == 7) {
	        cadastrarVendedor();  }
	    else if (op == 8) {
	        mostrarLoja(); }
	    else if (op == 9) {
	        mostrarContagens(); }
	    else if (op == 10) {
	    	mostrarMediaEBonus(); }
	    else if (op==11) {
	    	System.out.println("Sistema encerrado!");
	        System.exit(0); }
	    else {
	        System.out.println("ERRO - Digite uma opção válida (1 a 11)"); }
	}
	
	public static void calcularPreco() {
	
	System.out.println("Dona Gabrielinha, insira por gentileza a quntidade da planta desejada vendida:");
	int quant = scanner.nextInt();
	System.out.println("Certo!\nAgora insira o valor unitário:");
	double valoruni= scanner.nextDouble();
	
	double total = quant*valoruni;
	double desc =0;
	
	if(quant>10) { desc = total*0.05; }
	
	double totaldesc = total- desc;
	
	System.out.printf("Total: %.2f\nDesconto concedido: %.2f\n", totaldesc, desc);
	
	menuPrincipal();
	
	}
	
	public static void calcularTroco() {
		System.out.println("Dona Gabrielinha, insira por gentileza o valor pago pelo cliente:");
		double valorp = scanner.nextDouble();
		System.out.println("Certo!\nAgora insira o valor total da compra:");
		double valorc = scanner.nextDouble();
		double troco = valorp-valorc;
		System.out.printf("Troco: %.2f\n",troco);
	
		menuPrincipal();
	}
	
	
	public static void registrarVendacomdata() {
		
		System.out.println("Dona Gabrielinha, insira por gentileza a quntidade da planta desejada vendida:");
		int quant = scanner.nextInt();
		System.out.println("Certo!\nAgora insira o valor unitário:");
		double valoruni= scanner.nextDouble();
		System.out.println("Informe o dia da venda:");
		int dia = scanner.nextInt();
		System.out.println("Informe o mês da venda:");
		int mes = scanner.nextInt();
		
		
		
		double total = quant*valoruni;
		double desc =0;
		
		if(quant>10) { desc = total*0.05; }
		
		double totaldesc = total- desc;
		
		
		RegistroVendas.add(new Vendas(quant,valoruni, totaldesc, desc,dia,mes));
		System.out.println("Venda registrada!");
		
		menuPrincipal();
		
		}
	
	public static void buscarVendapordata() {
		
		System.out.println("Qual o dia da venda que deseja buscar?");
		int dia = scanner.nextInt();
		System.out.println("Qual o mes da venda que deseja buscar?");
		int mes = scanner.nextInt();
		
		int quantVendas=0;
		double valorTotal=0;
		
		for (Vendas venda : RegistroVendas) {
            if (venda.getDia() == dia && venda.getMes() == mes) {
                quantVendas += venda.getQuant();
                valorTotal += venda.getTotal();
            }}
		
		System.out.printf("No dia %d/%d houve %d vendas, totalizando R$ %.2f\n",
				dia, mes, quantVendas, valorTotal);
		
		menuPrincipal();
	}
	
	
	public static void RegistroVenda() {
		if(RegistroVendas.isEmpty()) {
			System.out.println("Nenhuma venda registrada!");
		}
		else {
		System.out.println("Registro de vendas:");
		for(Vendas venda : RegistroVendas) {
			System.out.printf("Quantidade: %d | Valor unitário: %.2f | Valor total: %.2f | Desconto: %.2f | Data: %d/%d\n",
					venda.getQuant(),venda.getValoruni() , venda.getTotal(), venda.getDesc(), venda.getDia(), venda.getMes()); }
		     }
		
		menuPrincipal();
	}
	
	public static void cadastrarCliente() {
        scanner.nextLine(); 
        System.out.println("Nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Idade:");
        int idade = scanner.nextInt(); scanner.nextLine();
        System.out.println("Cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Bairro:");
        String bairro = scanner.nextLine();
        System.out.println("Rua:");
        String rua = scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
        loja.adicionaCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        
        cliente.apresentarse();
        
        menuPrincipal();
    }

	public static void cadastrarVendedor() {
        scanner.nextLine();
        System.out.println("Nome do vendedor:");
        String nome = scanner.nextLine();
        System.out.println("Idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Bairro:");
        String bairro = scanner.nextLine();
        System.out.println("Rua:");
        String rua = scanner.nextLine();
        System.out.println("Salário base:");
        double salarioBase = scanner.nextDouble();

        Vendedor vendedor = new Vendedor(nome, idade, loja.getNomeFantasia(), cidade, bairro, rua, salarioBase);

        double[] salarios = new double[3];
        System.out.println("Agora insira três salários recebidos pelo funcionário para calcularmos uma média salarial:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Digite o salário %d recebido pelo vendedor: ", i + 1);
            salarios[i] = scanner.nextDouble();
            vendedor.adicionarSalario(salarios[i]);
        }

        loja.adicionaVendedor(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");

        menuPrincipal();
    }

    public static void mostrarLoja() {
        loja.apresentarse();
        
        menuPrincipal();
    }

    public static void mostrarContagens() {
        System.out.println("Clientes cadastrados: " + loja.contarClientes());
        System.out.println("Vendedores cadastrados: " + loja.contarVendedores());
        
        menuPrincipal();
    }
    
    public static void mostrarMediaEBonus() {
        if (loja.contarVendedores() == 0) {
            System.out.println("Nenhum vendedor cadastrado!");
        } else {
            System.out.println("Digite um número correspondente a um vendedor:");
            for (int i = 0; i < loja.contarVendedores(); i++) {
                System.out.printf("[%d] ", i);
                loja.getVendedores().get(i).apresentarse();
            }

            int indice = scanner.nextInt();
            Vendedor vendedor = loja.getVendedores().get(indice);

            double media = vendedor.calcularMedia();
            double bonus = vendedor.calcularBonus();

            System.out.printf("Média salarial baseada nos salários recebidos: R$ %.2f\n", media);
            System.out.printf("Bônus baseado no salário base: R$ %.2f\n", bonus);
        }

        menuPrincipal();
    }
    
    
}


