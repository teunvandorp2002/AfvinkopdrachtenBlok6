package week5;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Set;

public class GUI extends JFrame {
    public JComboBox<String> comboBox;
    public static JTextArea left, middle, right, results;

    public GUI() {
        this.setSize(620, 600);
        this.setTitle("Gene Finder");
        this.createGUI();
        this.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        Dimension size = new Dimension(200, 400);

        left = new JTextArea();
        left.setPreferredSize(size);
        window.add(left);
        middle = new JTextArea();
        middle.setPreferredSize(size);
        window.add(middle);
        right = new JTextArea();
        right.setPreferredSize(size);
        window.add(right);

        String[] choices = {"All", "Left and Middle", "Left and Right", "Middle and Right"};
        comboBox = new JComboBox(choices);
        window.add(comboBox);

        JButton calc = new JButton("Calculate");
        calc.addActionListener(e -> {
            GeneFinder.calculate(comboBox.getSelectedIndex());
        });
        window.add(calc);

        results = new JTextArea();
        results.setPreferredSize(new Dimension(620, 100));
        results.setEditable(false);
        results.setLineWrap(true);
        results.setWrapStyleWord(true);
        window.add(results);
    }

    public static String getLeft() {
        return left.getText();
    }
    public static String getMiddle() {
        return middle.getText();
    }
    public static String getRight() {
        return right.getText();
    }
    public static void setResults(Set<String> common) {
        results.setText("Common genes:\n");
        for (String gene : common) {
            results.append(gene + "   ");
        }
    }
}
