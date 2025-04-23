package Alunos.Braian.Prova_1trim;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private final ArrayList<Livro> livros;
    private final ArrayList<Cliente> clientes;
    public static Scanner scanner = new Scanner(System.in);

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.exibirMenu();
    }

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Cadastro de Livro");
            System.out.println("3 - Buscar Livro por Título");
            System.out.println("4 - Buscar Livro por Autor");
            System.out.println("5 - Empréstimo de Livro");
            System.out.println("6 - Devolução de Livro");
            System.out.println("7 - Verificar Disponibilidade de Livro");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarLivro();
                case 3 -> buscarPorTitulo();
                case 4 -> buscarPorAutor();
                case 5 -> emprestarLivro();
                case 6 -> devolverLivro();
                case 7 -> verificarDisponibilidade();
                case 8 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos de interação com o cliente
    public void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite a cidade do cliente: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o bairro do cliente: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite a rua do cliente: ");
        String rua = scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarLivro() {
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o gênero do livro: ");
        String genero = scanner.nextLine();
        System.out.print("Digite o ano de publicação do livro: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Esse livro é raro? (s/n): ");
        String resposta = scanner.nextLine();

        Livro livro;
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a explicação da raridade do livro: ");
            String explicacao = scanner.nextLine();
            livro = new LivroRaro(nomeLivro, autor, genero, ano, explicacao);
        } else {
            livro = new LivroComum(nomeLivro, autor, genero, ano);
        }
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void buscarPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.getNomeLivro().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void buscarPorAutor() {
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void emprestarLivro() {
        System.out.print("Digite o nome do livro que deseja emprestar: ");
        String titulo = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.getNomeLivro().equalsIgnoreCase(titulo)) {
                if (livro.podeSerEmprestado()) {
                    livro.setDisponivel(false);
                    System.out.println("Empréstimo realizado com sucesso!");
                    return;
                } else {
                    System.out.println("Este livro não pode ser emprestado.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void devolverLivro() {
        System.out.print("Digite o nome do livro que deseja devolver: ");
        String titulo = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.getNomeLivro().equalsIgnoreCase(titulo)) {
                if (!livro.isDisponivel()) {
                    System.out.print("Quantos dias de atraso? ");
                    int diasAtraso = Integer.parseInt(scanner.nextLine());
                    if (diasAtraso > 7) {
                        double multa = (diasAtraso - 7) * 3.50;
                        System.out.println("Multa de R$ " + multa + " gerada.");
                    }
                    livro.setDisponivel(true);
                    System.out.println("Devolução realizada com sucesso!");
                    return;
                } else {
                    System.out.println("Este livro não foi emprestado.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void verificarDisponibilidade() {
        System.out.print("Digite o nome do livro: ");
        String titulo = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.getNomeLivro().equalsIgnoreCase(titulo)) {
                System.out.println(livro.isDisponivel() ? "Livro disponível." : "Livro não disponível.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}
