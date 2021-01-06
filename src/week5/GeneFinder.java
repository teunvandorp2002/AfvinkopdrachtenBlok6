package week5;

import javax.swing.*;
import java.util.*;

public class GeneFinder {
    private static GUI gui;

    public static void main(String[] args) {
        gui = new GUI();
    }

    public static void calculate(int item) {
        Set<String> left = new HashSet<>(Arrays.asList(GUI.getLeft().split("\n")));
        Set<String> middle = new HashSet<>(Arrays.asList(GUI.getMiddle().split("\n")));
        Set<String> right = new HashSet<>(Arrays.asList(GUI.getRight().split("\n")));

        Set<String> common = new HashSet<>();

        /*System.out.println(left);
        System.out.println(middle);
        System.out.println(right);*/

        if (item == 0) {
            for (String gene : left) {
                if (middle.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
                if (right.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
            }
            for (String gene : middle) {
                if (right.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
            }
        } else if (item == 1) {
            for (String gene : left) {
                if (middle.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
            }
        } else if (item == 2) {
            for (String gene : left) {
                if (right.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
            }
        } else if (item == 3) {
            for (String gene : middle) {
                if (right.contains(gene) && !gene.equals("")) {
                    common.add(gene);
                }
            }
        } else {
            JOptionPane.showMessageDialog(gui, "ERROR THING");
        }

        System.out.println(common);
        GUI.setResults(common);

    }
}
