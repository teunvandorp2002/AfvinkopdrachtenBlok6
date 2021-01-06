package week5;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AminoAcidDictionary {
    public static void main(String[] args) {
        String[][] aminos = readFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 1, 3 letter code or amino acid name:");
        String input = scanner.next();

        if (input.length() == 1) {
            oneLetter(input.toUpperCase(), aminos);
        } else if (input.length() == 3) {
            threeLetters(input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase(), aminos);
        } else if (input.length() > 3) {
            fullName(input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase(), aminos);
        } else {
            System.out.println("Not an existing name type, try again");
            main(new String[]{});
        }
        System.out.println("Continue? [Y/N]");
        input = scanner.next();
        if (input.equalsIgnoreCase("y")) {
            main(new String[]{});
        } else {
            System.out.println("Quitting");
        }
    }

    private static void oneLetter(String aa, String[][] aminos) {
        HashMap<String, String[]> one = new HashMap<>(20);
        for (int i = 0; i < aminos.length; i++) {
            one.put(aminos[i][2], new String[]{aminos[i][1], aminos[i][0]});
        }
        String[] temp = one.get(aa);
        if (temp == null) {
            System.out.println("Amino acid non existent: " + aa);
            main(new String[]{});
        }
        System.out.println("One letter code:\t" + aa);
        System.out.println("Three letter code:\t" + temp[0]);
        System.out.println("Full name:\t\t\t" + temp[1]);
    }

    private static void threeLetters(String aa, String[][] aminos) {
        HashMap<String, String[]> three = new HashMap<>(20);
        for (int i = 0; i < aminos.length; i++) {
            three.put(aminos[i][1], new String[]{aminos[i][2], aminos[i][0]});
        }
        String[] temp = three.get(aa);
        if (temp == null) {
            System.out.println("Amino acid non existent: " + aa);
            main(new String[]{});
        }
        System.out.println("One letter code:\t" + temp[0]);
        System.out.println("Three letter code:\t" + aa);
        System.out.println("Full name:\t\t\t" + temp[1]);
    }

    private static void fullName(String aa, String[][] aminos) {
        HashMap<String, String[]> full = new HashMap<>(20);
        for (int i = 0; i < 20; i++) {
            full.put(aminos[i][0], new String[]{aminos[i][1], aminos[i][2]});
        }
        String[] temp = full.get(aa);
        if (temp == null) {
            System.out.println("Amino acid non existent: " + aa);
            main(new String[]{});
        }
        System.out.println("One letter code:\t" + temp[1]);
        System.out.println("Three letter code:\t" + temp[0]);
        System.out.println("Full name:\t\t\t" + aa);
    }

    public static String[][] readFile() {
        String[][] aminoAcids = new String[20][3];
        int row = 0;
        try {
            BufferedReader inFile = new BufferedReader(new FileReader("AminoAcids.csv"));
            String line;
            for (int i = 0; i < 20; i++) {
                line = inFile.readLine();
                aminoAcids[i] = line.split("\t");
            }
            /*while ((line = inFile.readLine()) != null) {
                aminoAcids[row] = line.split("\t");
                row++;
            }*/
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return aminoAcids;
    }
}