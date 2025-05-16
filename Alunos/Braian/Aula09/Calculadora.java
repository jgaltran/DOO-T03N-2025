package Alunos.Braian.Aula09;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Calculadora extends JFrame {
    private JTextField display;
    private StringBuilder currentInput;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        currentInput = new StringBuilder();

        // Layout do painel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Display para mostrar o resultado
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(display, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Definindo os botões
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Adicionando botões
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Adicionando o painel ao frame
        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if (command.equals("=")) {
                    // Calcular o resultado
                    calcular();
                } else if (command.equals("/")) {
                    currentInput.append(" / ");
                    display.setText(currentInput.toString());
                } else if (command.equals("*")) {
                    currentInput.append(" * ");
                    display.setText(currentInput.toString());
                } else if (command.equals("-")) {
                    currentInput.append(" - ");
                    display.setText(currentInput.toString());
                } else if (command.equals("+")) {
                    currentInput.append(" + ");
                    display.setText(currentInput.toString());
                } else {
                    // Construir a expressão
                    currentInput.append(command);
                    display.setText(currentInput.toString());
                }
            } catch (CalculadoraException ex) {
                display.setText("Erro: " + ex.getMessage());
            }
        }
    }

    private void calcular() throws CalculadoraException {
        try {
            String expression = currentInput.toString();
            // Lógica de cálculo simples (apenas operações básicas)
            String[] tokens = expression.split(" ");
            if (tokens.length != 3) throw new CalculadoraException("Expressão inválida!");

            double num1 = Double.parseDouble(tokens[0]);
            double num2 = Double.parseDouble(tokens[2]);
            String operator = tokens[1];

            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new CalculadoraException("Divisão por zero!");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new CalculadoraException("Operação inválida!");
            }

            display.setText(String.valueOf(result));
            currentInput.setLength(0); // Limpa a entrada após cálculo
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Entrada inválida! Use apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
}
