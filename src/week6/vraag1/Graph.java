package week6.vraag1;

import java.util.*;

class Graph {
    public static void makeGraph(ArrayList<ArrayList<String>> genen) {
        ArrayList<String> header = new ArrayList<>(genen.get(0));
        ArrayList<String> seq = new ArrayList<>(genen.get(1));
        calc(seq, header);
    }

    private static void calc(ArrayList<String> seq, ArrayList<String> header) {
        String out = "";
        int count = 0;
        for (int i = 0; i < seq.size(); i++) {
            for (int j = 0; j < seq.size(); j++) {
                String x = seq.get(i);
                String y = seq.get(j);
                for (int k = 0; k < x.length(); k++) {
                    if (x.length() / 2 < x.length() - k) {
                        char posI = x.charAt(x.length() / 2 + k);
                        char posJ = y.charAt(k);
                        if (posI == posJ) {
                            count++;
                        }
                    }
                }
                if (!header.get(i).equals(header.get(j)) && count > 1) {
                    out += (header.get(i) + " overlapt met " + header.get(j) + "\n");
                }
                count = 0;
            }
        }
        System.out.println(out);
    }
}
