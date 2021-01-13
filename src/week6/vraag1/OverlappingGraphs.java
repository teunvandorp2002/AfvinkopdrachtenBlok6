package week6.vraag1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OverlappingGraphs {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> fasta = readFile();
        Graph.makeGraph(fasta);
    }

    public static ArrayList<ArrayList<String>> readFile() {
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<String> sequence = new ArrayList<>();
        String seq = "";
        int count = 0;
        try {
            BufferedReader inFile = new BufferedReader(new FileReader("miniFasta.txt"));
            String line;
            while ((line = inFile.readLine()) != null) {
                if (line.startsWith(">")) {
                    headers.add(line);
                    if (count != 0) {
                        sequence.add(seq);
                        seq = "";
                    }
                } else {
                    seq += line;
                }
                count++;
            }
            sequence.add(seq);
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ArrayList<ArrayList<String>> combined = new ArrayList<>();
        combined.add(headers);
        combined.add(sequence);
        return combined;
    }
}
