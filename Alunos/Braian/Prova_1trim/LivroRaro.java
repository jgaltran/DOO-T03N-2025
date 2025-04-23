package Alunos.Braian.Prova_1trim;

public class LivroRaro extends Livro {
    private final String explicacaoRaridade;

    public LivroRaro(String nomeLivro, String autor, String genero, Integer anoPublicacao, String explicacaoRaridade) {
        super(nomeLivro, autor, genero, anoPublicacao);
        this.explicacaoRaridade = explicacaoRaridade;
    }

    public String getExplicacaoRaridade() {
        return explicacaoRaridade;
    }

    @Override
    public boolean podeSerEmprestado() {
        if (isDisponivel()) {
            System.out.println("O livro " + getNomeLivro() + " pode ser emprestado.");
            return true;
        } else {
            System.out.println("O livro " + getNomeLivro() + " não pode ser emprestado.");
            return false;
    }
      }

    @Override
    public String toString() {
        return super.toString() + " | Explicação: " + explicacaoRaridade;
    }
}
