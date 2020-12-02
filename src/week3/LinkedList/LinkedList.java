package week3.LinkedList;

import week2.SortingGenes.Gene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LinkedList {

    private BufferedReader inFile;

    public LinkedList() {
        openFile();

    }

    private void openFile() {
        try {
            inFile = new BufferedReader(new FileReader("Homo_sapiens.gene_info"));
            String line;
            ArrayList<String[]> bestand = new ArrayList<>();
            ArrayList<String> chromosomen = new ArrayList<>();
            while ((line = inFile.readLine()) != null) {
                bestand.add(line.split("\t"));
            }
            inFile.close();

            for (int i = 0; i < bestand.size(); i++) {
                for (int j = 0; j < bestand.get(i).length; j++) {
                    if (chromosomen.contains(bestand.get(i)[6]) | bestand.get(i)[6].equals("chromosome")){
                        continue;
                    } else {
                        chromosomen.add(bestand.get(i)[6]);
                    }
                }
            }

            ArrayList<ArrayList<String>> Lijst_per_chromosoom = new ArrayList<>();
            int size = chromosomen.size();
            long startTime = System.currentTimeMillis(); //start aangeven wanneer lijst maken begint begint.
            for(int i = 0; i < size; i++)  {
                Lijst_per_chromosoom.add(new ArrayList<>());
            }

            for (int i = 0; i < chromosomen.size(); i++) {
                for (int j = 0; j < bestand.size(); j++) {
                    if (bestand.get(j)[6].equals("chromosome")){
                        continue;
                    } else if (chromosomen.get(i).equals(bestand.get(j)[6])) {
                        if (Lijst_per_chromosoom.get(i).contains(bestand.get(j)[7])) {
                            continue;
                        } else {
                            Lijst_per_chromosoom.get(i).add(bestand.get(j)[7]);
                        }
                    }
                }
            }
            long endTime = System.currentTimeMillis();//eind aangeven wanneer klaar is met maken van lijst.
            // Hieronder wordt de tijd bereken dat maken van de lijst erover doet, in millisecondes.
            System.out.println("Lijst maken kost: " + (endTime - startTime) + " milliseconds");
            System.out.println(Lijst_per_chromosoom);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File Error: " + e.toString());
        }
    }
}
