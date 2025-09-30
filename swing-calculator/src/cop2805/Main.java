package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        // Basic config
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        // Apparently you can set the window in the middle of the screen with this
        frame.setLocationRelativeTo(null);

        // Creating panel to use grid layout
        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Input fields
        JTextField firstNumField = new JTextField();
        JTextField secondNumField = new JTextField();

        // Operation selection
        String[] operations = { "Add", "Subtract", "Multiply", "Divide" };
        JComboBox<String> operation = new JComboBox<>(operations);

        // Result display
        JLabel resultLabel = new JLabel();

        // Adding first number label and field
        panel.add(new JLabel("First number:"));
        panel.add(firstNumField);

        // Adding second number label and field
        panel.add(new JLabel("Second number:"));
        panel.add(secondNumField);

        // Adding empty label and operation selector
        panel.add(new JLabel());
        panel.add(operation);

        // Adding empty label and calculate button
        panel.add(new JLabel());
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstNum = Double.parseDouble(firstNumField.getText());
                double secondNum = Double.parseDouble(secondNumField.getText());
                double result = 0.0;

                // Calculating based on selected operation
                switch (operation.getSelectedIndex()) {
                    // Instead of determining the operator based on selected string
                    // I realized I can get selected index, which I think is cleaner.
                    case 0:
                        result = firstNum + secondNum;
                        break;
                    case 1:
                        result = firstNum - secondNum;
                        break;
                    case 2:
                        result = firstNum * secondNum;
                        break;
                    case 3:
                        result = firstNum / secondNum;
                        break;
                }

                // Display result
                resultLabel.setText(String.valueOf(result));
            }
        });
        panel.add(button);

        // Adding empty label and result label
        panel.add(new JLabel());
        panel.add(resultLabel);

        // Adding panel to frame and showing
        frame.add(panel);
        frame.setVisible(true);
    }
}
