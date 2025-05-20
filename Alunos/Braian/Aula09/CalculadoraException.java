package Alunos.Braian.Aula09;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Superclasse base para exceções da calculadora
abstract class CalculadoraException extends Exception {
    public abstract void exibirMensagem(JFrame janela, JTextField campo);
}

// Exceção para divisão por zero
class DivisaoPorZeroException extends CalculadoraException {
    @Override
    public void exibirMensagem(JFrame janela, JTextField campo) {
        JOptionPane.showMessageDialog(
                janela,
                "Você tentou dividir por zero!",
                "Erro de Divisão",
                JOptionPane.ERROR_MESSAGE
        );
        campo.setText("0 / 0 = ERRO!!!");
    }
}

// Exceção para entradas não numéricas
class EntradaInvalidaException extends CalculadoraException {
    @Override
    public void exibirMensagem(JFrame janela, JTextField campo) {
        JOptionPane.showMessageDialog(
                janela,
                "Entrada inválida! Use apenas números.",
                "Erro de Entrada",
                JOptionPane.ERROR_MESSAGE
        );
        campo.setText("Erro: entrada inválida!");
    }
}

// Exceção para expressões incompletas ou mal formatadas
class ExpressaoInvalidaException extends CalculadoraException {
    @Override
    public void exibirMensagem(JFrame janela, JTextField campo) {
        JOptionPane.showMessageDialog(
                janela,
                "Expressão inválida! Use o formato: número operador número",
                "Erro de Expressão",
                JOptionPane.ERROR_MESSAGE
        );
        campo.setText("Erro: expressão inválida!");
    }
}
