package week2.SortingGenes;

import week2.SortingGenes.Gene;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortObjects {
    public ArrayList<Gene> nested = new ArrayList<>();

    public SortObjects(){
        String filename = "Homo_sapiens.gene_info";
        readFile(filename);
        Collections.sort(nested);
        for (Gene i : nested) {
            System.out.println(i.getLocus());
        }
    }

    public void readFile(String filename) {
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = inFile.readLine()) != null) {
                String[] regel = line.split("\t");
                if (!regel[7].equals("-")){
                    nested.add(new Gene(regel[6], regel[7]));
                }
            }
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "File in an unexpected format",
                    "Unknown Format", JOptionPane.ERROR_MESSAGE);
        }
    }
}
