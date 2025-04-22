import java.time.LocalDate;
import java.time.LocalDateTime;

public class Livro {
    private String tituloLivro;
    private String nomeAutor;
    private String descricaoLivro;
    private Raridade raridade;
    private boolean disponibilidade;
    private LocalDate ultimaDataEmprestado;


    public Livro(String tituloLivro, String nomeAutor, String descricaoLivro, Raridade raridade, boolean disponibilidade){
        this.tituloLivro = tituloLivro;
        this.nomeAutor = nomeAutor;
        this.descricaoLivro = descricaoLivro;
        this.raridade = raridade;
        this.disponibilidade = disponibilidade;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDescricaoLivro() {
        return descricaoLivro;
    }
    public void setDescricaoLivro(String descricaoLivro){
        this.descricaoLivro = descricaoLivro;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setUltimaDataEmprestado(LocalDate localDateTime){
        this.ultimaDataEmprestado = localDateTime;
    }

    public LocalDate getUltimaDataEmprestado(){
        return ultimaDataEmprestado;
    }


    @Override
    public String toString() {
        return "Titulo: " + tituloLivro + "\n" + "Autor: " + nomeAutor + "\n" + "Descrição: " + descricaoLivro + "\n" + "Raridade: " + raridade + "\n" + "Disponibilidade: " + disponibilidade;
    }
}
