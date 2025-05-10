package Biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
    }
    public double devolver() {
        long dias = ChronoUnit.DAYS.between(dataEmprestimo, LocalDate.now());
        livro.setEmprestado(false);
        if (dias > 7) {
            return (dias - 7) * 3.50;
        }
        return 0;
    }
    public Livro getLivro() {
        return livro;
    }
}
