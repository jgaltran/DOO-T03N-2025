package Biblioteca;

public class LivroComum extends Livro{
	public LivroComum(String titulo, String autor) {
        super(titulo, autor);
    }
	 @Override
	    public boolean podeEmprestar() {
	        return !isEmprestado();
	    }
}
