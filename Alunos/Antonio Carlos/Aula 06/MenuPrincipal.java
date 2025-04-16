package interfaceUsuario;
 
import tratamentos.TratamentoDeErros;    

import calculadora.Calculadora;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import objetosLoja.Vendedor;
import objetosLoja.Cliente;
import objetosLoja.Loja;



/*Classe principal que gerencia o menu interativo do sistema My Plant. Exibe um menu principal com opções para cálculos, registro de vendas, 
* busca de vendas (por data e mês), gerenciamento de vendedores e clientes, e exibição de informações da loja
* Coordena a interação do usuário, lendo as opções e direcionando para os métodos correspondentes
*/

public class MenuPrincipal {
	
	static Scanner scan = new Scanner(System.in);
	static Calculadora calculadora = new Calculadora();
	//Lista para armazenar as vendas com a data.
	static final Map<LocalDate, List<Vendas>> Vendas_Por_Data = new HashMap();
	
	private static Loja loja; // Instância da loja sendo gerenciada pelo sistema
	
	public static void main(String[] args) {
		
		inicializarLoja();
		
		int opcaoUsuario;
		
		do {
			exibirMenu();
			opcaoUsuario = TratamentoDeErros.lerInteiro(scan, "Escolha uma opção:");
			scan.nextLine();
			
			try {
				switch (opcaoUsuario) {
				case 1:
					calcularPrecoTotal();
					break;
				case 2:
					registrarVenda();
					break;
				case 3:
					calcularTroco();
					break;
				case 4:
					buscarVendasPorData();
					break;
				case 5:
					buscarVendasPorMes();
					break;
				case 6:
					exibirVenda();
					break;
				case 7:
					gerenciarVendedores();
					break;
				case 8:
					gerenciarClientes();
					break;
				case 9:
					exibirInformacoesLoja();
					break;
				case 10:
					System.out.println("Saindo do sistema...");
					System.out.println("Sistema encerrado!");
					break;
					default:
						System.out.println("Opção invlálida!");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}

	} while (opcaoUsuario !=10);
		scan.close();
	
	}
	// Cria e configura a instância inicial da loja.
	private static void inicializarLoja() {
        loja = new Loja("My Plant", "My Plant Comércio de Plantas Ltda.", "12.345.678/0001-99", "Cascavel", "Centro", "Rua Manoel Ribas, 123");
    }
	
	static void exibirMenu() {
		
		
		System.out.println("\n|--------------------------------|");
        System.out.println("|            My Plant            |");
        System.out.println("|--------------------------------|");
        System.out.println("| 1. Calcular Preço Total        |");
        System.out.println("| 2. Registrar Venda             |");
        System.out.println("| 3. Calcular Troco              |");
        System.out.println("| 4. Buscar Vendas por Data      |");
        System.out.println("| 5. Buscar Vendas por Mês       |");
        System.out.println("| 6. Exibir Todas as Vendas      |");
        System.out.println("| 7. Gerenciar Vendedor          |");
        System.out.println("| 8. Gerenciar Cliente           |");
        System.out.println("| 9. Exibir Informações da Loja  |");
        System.out.println("| 10. Sair                       |");
        System.out.println("|--------------------------------|");
	}
	
    // Calcula e exibe o preço total
	static void calcularPrecoTotal() {
		int quantidade = TratamentoDeErros.lerInteiro(scan,"Digite a quantidade: ");
		double precoUnitario = TratamentoDeErros.lerDouble(scan, "Digite o preço unitário: ");
		double precoTotal = calculadora.calcularPrecoTotal(quantidade, precoUnitario);
		System.out.printf("Preço total: R$%.2f\n", precoTotal);
	}
	
    // Registra uma nova venda
	static void registrarVenda() {
		int quantidade = TratamentoDeErros.lerInteiro(scan, "Digite a quantidade de plantas: ");
		double precoUnitario = TratamentoDeErros.lerDouble(scan, "Digite o preço unitário: ");
		
		LocalDate dataVenda = lerDataVenda(); //Lê data da venda.
		
		double valorVenda = calculadora.calcularPrecoTotal(quantidade, precoUnitario);
		double desconto = calculadora.calcularDesconto(quantidade,  valorVenda); // Calcula o desconto
		double valorFinal = valorVenda - desconto; // Valor final com desconto
		
		Vendas venda = new Vendas(quantidade, precoUnitario, valorVenda, desconto, dataVenda);
		
		Vendas_Por_Data.computeIfAbsent(dataVenda, k -> new ArrayList<>()).add(venda); // Adiciona a venda com a data

		
		System.out.printf("Venda registrada com sucesso! Valor final: R$%.2f\n", valorFinal);
		
	}
	
	// Método que lê e valida a data de venda inserida pelo usuário.
	static LocalDate lerDataVenda() {
		while (true) {
			System.out.println("Digite a data da vanda (dd/mm/aaa):");
			String dataString = scan.next();
			try {
				return LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida. Use o formato (dd/mm/aaaa).");
			}
		}
		
	}
	
	// Método para bscar vendas por data.
	static void buscarVendasPorData() {
		LocalDate dataBusca = lerDataVenda();
		
		List<Vendas> listaVendas = Vendas_Por_Data.get(dataBusca);
		
		if (listaVendas == null || listaVendas.isEmpty()) {
			System.out.println("Nenhuma vanda encontrada para esta data.");
			return;
		}
		
		System.out.println("---- Vendas em " + dataBusca.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ----");
	
	
	double totalVendas = 0;
	
	for (Vendas venda : listaVendas) {
		System.out.println(venda);
		totalVendas += venda.getValorVenda() - venda.getDesconto();
	}
	
	System.out.printf("Total de vendas na data: R$%.2f\n", totalVendas);
	}
	
	// Calcula e exibe o troco
	static void calcularTroco() {
        double recebido = TratamentoDeErros.lerDouble(scan,"Digite o valor recebido: ");
        double total = TratamentoDeErros.lerDouble(scan, "Digite o valor da compra: ");
        double troco = calculadora.calcularTroco(recebido, total);
        System.out.printf("Troco: R$%.2f\n", troco);

    }
	
	// Método para buscar vendas por mês.
	static void buscarVendasPorMes() {
		int mes = TratamentoDeErros.lerInteiro(scan, "Digite o mês (1-12):");
		
		if (mes < 1 || mes > 12) {
			System.out.println("Mês inválido.");
			return;
		}
		
		double totalVendasNoMes = 0;
		for (Map.Entry<LocalDate, List<Vendas>> entry : Vendas_Por_Data.entrySet()) {
            if (entry.getKey().getMonthValue() == mes) {
                for (Vendas venda : entry.getValue()) {
                    totalVendasNoMes += venda.getValorVenda()- venda.getDesconto();
                }
            }
        }
		
		if (totalVendasNoMes == 0) {
            System.out.println("Nenhuma venda encontrada para este mês.");
        } else {
            System.out.printf("Total de vendas no mês %d: R$%.2f\n", mes, totalVendasNoMes);
        }
		
		
	}
	
	// Exibe o histórico de vendas
	static void exibirVenda() {
		if (Vendas_Por_Data.isEmpty()) {
			System.out.println("Nenhuma venda registrada ainda.");
			return;
		}
		System.out.println("-----Histórico de Vendas-----");
		for (List<Vendas> vendasDoDia : Vendas_Por_Data.values()) {
		    for (Vendas venda : vendasDoDia) { // Itera sobre as vendas e imprime os detalhes
			System.out.println(venda);
			
		    }
		}
	}
	
	//  Exibe e gerencia o submenu de opções para vendedores.
	static void gerenciarVendedores() {
		int opcaoVendedor;
		
		do {
		
		System.out.println("\n|--------------------------------|");
        System.out.println("|   Gerenciador de Vendedores    |");
        System.out.println("|--------------------------------|");
        System.out.println("| 1. Adicionar Vendedor          |");
        System.out.println("| 2. Listar Vendedores           |");
        System.out.println("| 3. Calcular Média Salárial     |");
        System.out.println("| 4. Calcular Bônus Salárial     |");
        System.out.println("| 5. Voltar                      |");
        System.out.println("|--------------------------------|");
        
        opcaoVendedor = TratamentoDeErros.lerInteiro(scan, "Escolha uma opção:");
        scan.nextLine();

        // Direciona para a função do submenu escolhida
        switch (opcaoVendedor) {
            case 1:
                adicionarVendedor(); 
                break;
            case 2:
                listarVendedores();
                break;
            case 3:
                calcularMediaSalarial(); 
                break;
            case 4:
                calcularBonusVendedor(); 
                break;
            case 5:
                System.out.println("Voltando ao menu principal.");
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
        }
    } while (opcaoVendedor != 5);
}
		
	    static void adicionarVendedor() {
		
		
		System.out.println("Digite o nome do vendedor:");
        String nome = scan.next();
        scan.nextLine();

        int idade = TratamentoDeErros.lerInteiro(scan, "Digite a idade do vendedor:");
        System.out.println("Digite a cidade do vendedor:");
        String cidade = scan.next();
        scan.nextLine();
        System.out.println("Digite o bairro do vendedor:");
        String bairro = scan.next();
        scan.nextLine();

        System.out.println("Digite a rua do vendedor:");
        String rua = scan.next();
        scan.nextLine();

        double salarioBase = TratamentoDeErros.lerDouble(scan, "Digite o salário base do vendedor:");


        Vendedor vendedor = new Vendedor(nome, idade, loja, cidade, bairro, rua, salarioBase);


        loja.adicionarVendedor(vendedor);
        System.out.println("Vendedor adicionado com sucesso!");
        
		} 
	    
	    
	    static void listarVendedores() {
	    
	   
        
        List<Vendedor> vendedores = loja.getVendedores();
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado na loja.");
            return;
        }
        System.out.println("---- Vendedores da Loja " + loja.getNomeFantasia() + " ----");
        for (Vendedor listaVendedor : vendedores) {
            listaVendedor.apresentarSe();
        } 
        
	}
	    
	    static void calcularMediaSalarial() {
			
			List<Vendedor> vendedores = loja.getVendedores();


	        if (vendedores.isEmpty()) {
	            System.out.println("Nenhum vendedor cadastrado para calcular a média salarial.");
	            return;
	        }


	        System.out.println("Digite o nome do vendedor para calcular a média salarial:");
	        String nomeVendedor = scan.next();
	        scan.nextLine();

	        for (Vendedor vendedor : vendedores) {
	            if (vendedor.getNome().equalsIgnoreCase(nomeVendedor)) { 

	                double mediaSalarial = vendedor.calcularMediaSalarial();
	                System.out.printf("Média salarial de %s: R$%.2f\n", vendedor.getNome(), mediaSalarial);
	                return;
	            }

	        }

	        System.out.println("Vendedor não encontrado.");  
			
	}
		
		static void calcularBonusVendedor() {
			
			List<Vendedor> vendedores = loja.getVendedores();
	        if (vendedores.isEmpty()) {
	            System.out.println("Nenhum vendedor cadastrado para calcular o bônus.");
	            return;
	        }


	        System.out.println("Digite o nome do vendedor para calcular o bônus:");

	        String nomeVendedor = scan.next();
	        scan.nextLine();


	        for (Vendedor vendedor : vendedores) {

	            if (vendedor.getNome().equalsIgnoreCase(nomeVendedor)) {

	                double bonus = vendedor.calcularBonus();

	                System.out.printf("Bônus de %s: R$%.2f\n", vendedor.getNome(), bonus);
	                return;
	            }
	        }


	        System.out.println("Vendedor não encontrado.");
		}

	 static void gerenciarClientes() {
		 
		 int opcaoCliente;
			
			do {
			
			System.out.println("\n|--------------------------------|");
	        System.out.println("|   Gerenciador de Clientes      |");
	        System.out.println("|--------------------------------|");
	        System.out.println("| 1. Adicionar Cliente           |");
	        System.out.println("| 2. Listar Cliente              |");
	        System.out.println("| 3. Voltar                      |");
	        System.out.println("|--------------------------------|");
	        
	        opcaoCliente = TratamentoDeErros.lerInteiro(scan, "Escolha uma opção:");
	        scan.nextLine();

	        switch (opcaoCliente) {
	            case 1:
	                adicionarCliente(); 
	                break;
	            case 2:
	                listarCliente();
	                break;
	            case 3:
	                System.out.println("Voltando ao menu principal.");
	                break;
	            default:
	                System.out.println("Opção inválida, tente novamente!");
	        }
	    } while (opcaoCliente != 3);
	}
	 
		 
		static void adicionarCliente() {
		
		System.out.println("Digite o nome do cliente:");

        String nome = scan.next();
        scan.nextLine();


        int idade = TratamentoDeErros.lerInteiro(scan, "Digite a idade do cliente:");

        System.out.println("Digite a cidade do cliente:");

        String cidade = scan.next();
        scan.nextLine();

        System.out.println("Digite o bairro do cliente:");

        String bairro = scan.next();
        scan.nextLine();


        System.out.println("Digite a rua do cliente:");

        String rua = scan.next();
        scan.nextLine();

        Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);

        loja.adicionarCliente(cliente);

        System.out.println("Cliente adicionado com sucesso!");
		
	}
		
		static void listarCliente() {
			
			List<Cliente> clientes = loja.getClientes();
	        if (clientes.isEmpty()) {
	            System.out.println("Nenhum cliente cadastrado na loja.");
	            return;
	        }
	        System.out.println("---- Clientes da Loja " + loja.getNomeFantasia() + " ----");
	        for (Cliente cliente : clientes) {
	            cliente.apresentarSe();
	        }
			
		}
	
	static void exibirInformacoesLoja() {
		
		loja.apresentarSe();
        System.out.println("Número de clientes: " + loja.contarClientes());
        System.out.println("Número de vendedores: " + loja.contarVendedores());
		
	}
		
}
