package Biblioteca;

public class LivroRaro extends Livro {
	private String justificativaRaridade;
	
	 public LivroRaro(String titulo, String autor, String justificativaRaridade) {
	        super(titulo, autor);
	        this.justificativaRaridade = justificativaRaridade;
	    }
	 @Override
	    public boolean podeEmprestar() {
	        return false;
	    }

	    public String getJustificativaRaridade() {
	        return justificativaRaridade;
	    }
	}



