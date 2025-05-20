package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Livro buscarPorTitulo(String titulo) {
        return livros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    public Livro buscarPorAutor(String autor) {
        return livros.stream().filter(l -> l.getAutor().equalsIgnoreCase(autor)).findFirst().orElse(null);
    }

    public boolean realizarEmprestimo(String titulo, Cliente cliente) {
        Livro livro = buscarPorTitulo(titulo);
        if (livro != null && livro.podeEmprestar()) {
            livro.setEmprestado(true);
            emprestimos.add(new Emprestimo(livro, cliente));
            return true;
        }
        return false;
    }

    public double devolverLivro(String titulo) {
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                double multa = e.devolver();
                emprestimos.remove(e);
                return multa;
            }
        }
        return 0;
    }

    public boolean estaDisponivel(String titulo) {
        Livro livro = buscarPorTitulo(titulo);
        return livro != null && livro.podeEmprestar();
    }
}
