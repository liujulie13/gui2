package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionCalculatorApp extends JFrame {
    private JTextField kilometerField;
    private JLabel resultLabel;

    public ConversionCalculatorApp() {
        setTitle("Kilometer to Mile Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

        createComponents();

        pack();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        JLabel kilometerLabel = new JLabel("Kilometers:");
        add(kilometerLabel);

        kilometerField = new JTextField(10);
        add(kilometerField);

        JButton convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double kilometer = Double.parseDouble(kilometerField.getText());
                    double mile = kilometer * 0.621371;
                    resultLabel.setText("Result: " + mile);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConversionCalculatorApp().setVisible(true);
            }
        });
    }
}
