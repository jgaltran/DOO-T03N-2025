import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Clientes> clientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- BibliotecaPub ---");
            System.out.println("1. Cadastrar cliente e livro");
            System.out.println("2. Buscar livro por título");
            System.out.println("3. Buscar livro por autor");
            System.out.println("4. Realizar empréstimo");
            System.out.println("5. Realizar devolução");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    Clientes cliente = new Clientes(nome);

                    System.out.print("Tipo do livro (1 - Comum | 2 - Raro): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do livro: ");
                    String nomeLivro = scanner.nextLine();
                    System.out.print("Nome do autor: ");
                    String nomeAutor = scanner.nextLine();

                    Livros livro;
                    if (tipo == 1) {
                        livro = new Comum(nomeLivro, nomeAutor);
                    } else {
                        System.out.print("Motivo de ser raro: ");
                        String motivo = scanner.nextLine();
                        livro = new Raro(nomeLivro, nomeAutor, motivo);
                    }

                    cliente.livros.add(livro);
                    clientes.add(cliente);
                    System.out.println("Cliente e livro cadastrados!");
                }

                case 2 -> {
                    System.out.print("Digite o título do livro: ");
                    String busca = scanner.nextLine();
                    Livros achado = encontrarLivroPorTitulo(busca);

                    if (achado != null) {
                        System.out.println("Livro encontrado: " + achado.nomeLivro + " - " + achado.nomeAutor);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 3 -> {
                    System.out.print("Digite o nome do autor: ");
                    String busca = scanner.nextLine();
                    Livros achado = encontrarLivroPorAutor(busca);

                    if (achado != null) {
                        System.out.println("Livro encontrado: " + achado.nomeLivro + " - " + achado.nomeAutor);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 4 -> {
                    System.out.print("Nome do livro para empréstimo: ");
                    String nomeLivro = scanner.nextLine();
                    Livros livro = encontrarLivroPorTitulo(nomeLivro);

                    if (livro != null) {
                        livro.registrarEmprestimo();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 5 -> {
                    System.out.print("Nome do livro para devolução: ");
                    String nomeLivro = scanner.nextLine();
                    Livros livro = encontrarLivroPorTitulo(nomeLivro);

                    if (livro != null) {
                        livro.registrarDevolucao();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                default -> System.out.println("Opção inválida.");
            }
        }
    }

    static Livros encontrarLivroPorTitulo(String titulo) {
        for (Clientes c : clientes) {
            for (Livros l : c.livros) {
                if (l.nomeLivro.equalsIgnoreCase(titulo)) {
                    return l;
                }
            }
        }
        return null;
    }

    static Livros encontrarLivroPorAutor(String autor) {
        for (Clientes c : clientes) {
            for (Livros l : c.livros) {
                if (l.nomeAutor.equalsIgnoreCase(autor)) {
                    return l;
                }
            }
        }
        return null;
    }
}
