package Alunos.Braian.Prova_1trim;

public class Livro {
    private final String nomeLivro;
    private final String autor;
    private final String genero;
    private final Integer anoPublicacao;
    private boolean disponivel;

    public Livro(String nomeLivro, String autor, String genero, Integer anoPublicacao) {
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    // Getters and Setters
    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro: " + nomeLivro + " | Autor: " + autor + " | Ano: " + anoPublicacao + " | Disponibilidade: " + (disponivel ? "Disponível" : "Indisponível");
    }

    public boolean podeSerEmprestado() {
        return true; // Por padrão, todos os livros podem ser emprestados
    }

}
