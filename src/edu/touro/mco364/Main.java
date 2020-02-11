package edu.touro.mco364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Calc2 extends JFrame {
    private JTextField input1 = new JTextField(20),
            input2 = new JTextField(20);
    private JLabel result = new JLabel("-");
    private JButton plusButton = new JButton("+"),
            minusButton = new JButton("-"),
            timesButton = new JButton("x"),
            divideButton = new JButton("/");

    public Calc2() {
        // GUI Layout
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(plusButton);
        add(minusButton);
        add(timesButton);
        add(divideButton);

        add(input1);
        add(input2);
        add(result);

        setSize(500, 800);
        setVisible(true);

        // GUI Layout end

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double val1 = getDoubleFromTextField(input1);
                double val2 = getDoubleFromTextField(input2);
                double resultD = 0;

                // String op = actionEvent.getActionCommand();
                String op = ((JButton)actionEvent.getSource()).getText(); // same result as getActionCommand
                switch (op) {
                    case "+":
                        resultD = val1+val2;
                        break;
                    case "-":
                        resultD = val1-val2;
                        break;
                    case "x":
                        resultD = val1*val2;
                        break;
                    case "/":
                        resultD = val1/val2;
                        break;
                }
                result.setText(Double.isFinite(resultD) ? resultD + "" : "Undefined");
            }};

        plusButton.addActionListener(al);
        minusButton.addActionListener(al);
        timesButton.addActionListener(al);
        divideButton.addActionListener(al);
    }

    private double getDoubleFromTextField(JTextField tf) {
        try{
            return Double.parseDouble(tf.getText());
        }
        catch (NumberFormatException e)
        {
            tf.setText("0");
            return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    new GraphicFrame();
    }
}
