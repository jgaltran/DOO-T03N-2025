package Alunos.Braian.Aula09;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculadora extends JFrame {
    private final JTextField display;
    private final StringBuilder currentInput;

    public Calculadora() {
        JFrame frame = new JFrame("Calculadora Simples");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentInput = new StringBuilder();

        JPanel panel = new JPanel(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if (command.equals("=")) {
                    calcular();
                } else {
                    if (display.getText().startsWith("Erro")) {
                        currentInput.setLength(0);
                    }
                    if ("+-*/".contains(command)) {
                        currentInput.append(" ").append(command).append(" ");
                    } else {
                        currentInput.append(command);
                    }
                    display.setText(currentInput.toString());
                }
            } catch (CalculadoraException ex) {
                display.setText("Erro: " + ex.getMessage());
                currentInput.setLength(0);
            }
        }
    }

    private void calcular() throws CalculadoraException {
        try {
            String expression = currentInput.toString().trim();
            String[] tokens = expression.split(" ");
            if (tokens.length != 3) throw new CalculadoraException("Expressão inválida!");

            double num1 = Double.parseDouble(tokens[0]);
            double num2 = Double.parseDouble(tokens[2]);
            String operator = tokens[1];

            double result;
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) throw new CalculadoraException("Divisão por zero!");
                    result = num1 / num2;
                }
                default -> throw new CalculadoraException("Operador inválido!");
            }

            display.setText(String.valueOf(result));
            currentInput.setLength(0);
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Entrada inválida! Use apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}

// Classe de exceção personalizada
class CalculadoraException extends Exception {
    public CalculadoraException(String mensagem) {
        super(mensagem);
    }
}
