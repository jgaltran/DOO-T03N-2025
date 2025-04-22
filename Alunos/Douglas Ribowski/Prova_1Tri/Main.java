package Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== BibliotecaPub ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Livro Comum");
            System.out.println("3. Cadastrar Livro Raro");
            System.out.println("4. Buscar Livro por Título");
            System.out.println("5. Buscar Livro por Autor");
            System.out.println("6. Realizar Empréstimo");
            System.out.println("7. Devolver Livro");
            System.out.println("8. Verificar Disponibilidade");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    biblioteca.cadastrarCliente(new Cliente(nome, cpf));
                    System.out.println("Cliente cadastrado.");
                    break;
                case 2:
                    System.out.print("Título: ");
                    String tituloComum = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorComum = scanner.nextLine();
                    biblioteca.cadastrarLivro(new LivroComum(tituloComum, autorComum));
                    System.out.println("Livro comum cadastrado.");
                    break;
                case 3:
                    System.out.print("Título: ");
                    String tituloRaro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorRaro = scanner.nextLine();
                    System.out.print("Justificativa de raridade: ");
                    String justificativa = scanner.nextLine();
                    biblioteca.cadastrarLivro(new LivroRaro(tituloRaro, autorRaro, justificativa));
                    System.out.println("Livro raro cadastrado.");
                    break;
                case 4:
                    System.out.print("Digite o título: ");
                    String tituloBusca = scanner.nextLine();
                    Livro l1 = biblioteca.buscarPorTitulo(tituloBusca);
                    System.out.println(l1 != null ? "Livro encontrado: " + l1.getTitulo() : "Livro não encontrado.");
                    break;
                case 5:
                    System.out.print("Digite o autor: ");
                    String autorBusca = scanner.nextLine();
                    Livro l2 = biblioteca.buscarPorAutor(autorBusca);
                    System.out.println(l2 != null ? "Livro encontrado: " + l2.getTitulo() : "Livro não encontrado.");
                    break;
                case 6:
                    System.out.print("Título do livro: ");
                    String tituloEmp = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfEmp = scanner.nextLine();
                    Cliente clienteEmp = biblioteca.getClientes().stream()
                    	    .filter(c -> c.getCpf().equals(cpfEmp))
                    	    .findFirst()
                    	    .orElse(null);

                    if (clienteEmp != null) {
                        boolean sucesso = biblioteca.realizarEmprestimo(tituloEmp, clienteEmp);
                        System.out.println(sucesso ? "Empréstimo realizado." : "Não foi possível realizar o empréstimo.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Título do livro a devolver: ");
                    String tituloDev = scanner.nextLine();
                    double multa = biblioteca.devolverLivro(tituloDev);
                    if (multa > 0) {
                        System.out.printf("Livro devolvido com multa de R$ %.2f\n", multa);
                    } else {
                        System.out.println("Livro devolvido sem multa.");
                    }
                    break;
                case 8:
                    System.out.print("Título do livro: ");
                    String tituloDisp = scanner.nextLine();
                    System.out.println(biblioteca.estaDisponivel(tituloDisp) ?
                            "Disponível para empréstimo." :
                            "Indisponível para empréstimo.");
                    break;
                case 9:
                    executando = false;
                    System.out.println("Encerrando sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
