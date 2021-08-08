package calc;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    private final Font arial20 = new Font("Arial", Font.PLAIN, 20);
    public double firstNum;
    public double secondNum;
    public double result;
    public String operations = "";
    public String answer;
    public boolean ex = false;
    public boolean clear = false;
    private JFrame frame;
    private JTextField text;

    /**
     * Create the application.
     */
    public Calculator() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calculator window = new Calculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public double Add(double firstNum, double secondNum) {
        return (firstNum + secondNum);
    }

    public double Substract(double firstNum, double secondNum) {
        return (firstNum - secondNum);
    }

    public double Multiply(double firstNum, double secondNum) {
        return (firstNum * secondNum);
    }

    public double Divide(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException();
        }
        return (firstNum / secondNum);
    }

    public double Remainder(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException();
        }
        return (firstNum % secondNum);
    }

    public double Power(double firstNum, double secondNum) {
        return Math.pow(firstNum, secondNum);
    }

    public double Sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException();
        }
        return Math.sqrt(num);
    }

    public double Factorial(double num) {
        int i, fact = 1;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public String Backspace(String txt) {
        return txt != null ? txt.substring(0, txt.length() - 1) : null;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 281, 471);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        text = new JTextField();
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setFont(arial20);
        text.setBounds(10, 11, 242, 40);
        frame.getContentPane().add(text);
        text.setColumns(10);


        //BACK
        JButton btnBack = new JButton("\u2190");
        btnBack.addActionListener(e -> text.setText(Backspace(text.getText())));
        btnBack.setFont(new Font("Arial", Font.PLAIN, 18));
        btnBack.setBounds(10, 62, 53, 50);
        frame.getContentPane().add(btnBack);

        //C
        JButton btnC = new JButton("C");
        btnC.addActionListener(e -> text.setText(null));
        btnC.setFont(arial20);
        btnC.setBounds(73, 62, 53, 50);
        frame.getContentPane().add(btnC);

        //PERCENT
        JButton btnPercent = new JButton("%");
        btnPercent.addActionListener(e -> {
            if (text.getText().length() > 0) {
                firstNum = Double.parseDouble(text.getText());
                text.setText("");
                operations = "%";
            }
        });
        btnPercent.setFont(arial20);
        btnPercent.setBounds(136, 62, 53, 50);
        frame.getContentPane().add(btnPercent);

        //PLUS
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    firstNum = Double.parseDouble(text.getText());
                    text.setText("");
                    operations = "+";
                }
            }
        });
        btnPlus.setFont(arial20);
        btnPlus.setBounds(199, 62, 53, 50);
        frame.getContentPane().add(btnPlus);

        //MINUS
        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    firstNum = Double.parseDouble(text.getText());
                    text.setText("");
                    operations = "-";
                }
            }
        });
        btnMinus.setFont(arial20);
        btnMinus.setBounds(199, 123, 53, 50);
        frame.getContentPane().add(btnMinus);

        //MULTIPLICATION
        JButton btnMult = new JButton("*");
        btnMult.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    firstNum = Double.parseDouble(text.getText());
                    text.setText("");
                    operations = "*";
                }
            }
        });
        btnMult.setFont(arial20);
        btnMult.setBounds(199, 184, 53, 50);
        frame.getContentPane().add(btnMult);

        //DIVISION
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    firstNum = Double.parseDouble(text.getText());
                    text.setText("");
                    operations = "/";
                }
            }
        });
        btnDiv.setFont(arial20);
        btnDiv.setBounds(199, 245, 53, 50);
        frame.getContentPane().add(btnDiv);

        //PLUS MINUS
        JButton btnPlusMinus = new JButton("\u00B1");
        btnPlusMinus.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    double ops = Double.parseDouble(String.valueOf(text.getText()));
                    ops *= (-1);
                    text.setText(String.valueOf(ops));
                }
            }
        });
        btnPlusMinus.setFont(arial20);
        btnPlusMinus.setBounds(10, 367, 53, 50);
        frame.getContentPane().add(btnPlusMinus);

        //POINT
        JButton btnPoint = new JButton(".");
        btnPoint.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    text.setText(text.getText() + btnPoint.getText());
                }
            }
        });
        btnPoint.setFont(arial20);
        btnPoint.setBounds(136, 367, 53, 50);
        frame.getContentPane().add(btnPoint);

        //SQUARE ROOT
        JButton btnSqrt = new JButton("\u221A");
        btnSqrt.addActionListener(e -> {
            operations = "sqrt";
            text.setText(null);
        });
        btnSqrt.setFont(arial20);
        btnSqrt.setBounds(10, 123, 53, 50);
        frame.getContentPane().add(btnSqrt);

        //POWER
        JButton btn0_1 = new JButton("^");
        btn0_1.addActionListener(e -> {
            if (text.getText().length() > 0) {
                if (clear) {
                    text.setText(null);
                    clear = false;
                } else {
                    firstNum = Double.parseDouble(text.getText());
                    text.setText("");
                    operations = "^";
                }
            }
        });
        btn0_1.setFont(arial20);
        btn0_1.setBounds(136, 123, 53, 50);
        frame.getContentPane().add(btn0_1);

        //FACTORIAL
        JButton btnFactorial = new JButton("!");
        btnFactorial.addActionListener(e -> {
            if (text.getText().length() > 0) {
                firstNum = Double.parseDouble(text.getText());
                text.setText(text.getText() + btnFactorial.getText());
                operations = "fact";
            }
        });
        btnFactorial.setFont(arial20);
        btnFactorial.setBounds(73, 123, 53, 50);
        frame.getContentPane().add(btnFactorial);

        //EQUALS
        JButton btnEquals = new JButton("=");
        btnEquals.addActionListener(e -> {

            if (!operations.equals("fact"))
                if (text.getText().length() > 0)
                    secondNum = Double.parseDouble(text.getText());
                else secondNum = 0;

            switch (operations) {
                case ("+"):
                    result = Add(firstNum, secondNum);
                    break;
                case ("-"):
                    result = firstNum - secondNum;
                    break;
                case ("*"):
                    result = firstNum * secondNum;
                    break;
                case ("/"): {
                    try {
                        result = Divide(firstNum, secondNum);
                    } catch (ArithmeticException e1) {
                        ex = true;
                        answer = "You can`t divide by zero";
                    }
                }
                break;
                case ("%"): {
                    try {
                        result = Remainder(firstNum, secondNum);
                    } catch (ArithmeticException e1) {
                        ex = true;
                        answer = "You can`t divide by zero";
                    }
                }
                break;
                case ("^"):
                    result = Power(firstNum, secondNum);
                    break;
                case ("sqrt"): {
                    try {
                        result = Sqrt(secondNum);
                    } catch (ArithmeticException e1) {
                        ex = true;
                        answer = "Imaginary number";
                    }
                }
                break;
                case ("fact"):
                    result = Factorial(firstNum);
                    break;
                default: {
                    result = firstNum;
                }
            }
            if (!ex) answer = String.format("%.2f", result);
            else ex = false;
            text.setText(answer);
            clear = true;
        });
        btnEquals.setFont(arial20);
        btnEquals.setBounds(199, 306, 53, 111);
        frame.getContentPane().add(btnEquals);


        //DIGITS
        addNumberButton("1", 10, 306);
        addNumberButton("2", 73, 306);
        addNumberButton("3", 136, 306);
        addNumberButton("4", 10, 245);
        addNumberButton("5", 73, 245);
        addNumberButton("6", 136, 245);
        addNumberButton("7", 10, 184);
        addNumberButton("8", 73, 184);
        addNumberButton("9", 136, 184);
        addNumberButton("0", 73, 367);

    }

    private void addNumberButton(String label, int posX, int posY) {
        JButton btn0 = new JButton(label);
        addButtonListener(btn0);
        btn0.setBounds(posX, posY, 53, 50);
        frame.getContentPane().add(btn0);
    }

    private void addButtonListener(JButton button) {
        button.addActionListener(e -> {
            if (clear) {
                text.setText(null);
                clear = false;
            }
            String EnterNumber = text.getText() + button.getText();
            text.setText(EnterNumber);

        });
        button.setFont(arial20);
    }
}
