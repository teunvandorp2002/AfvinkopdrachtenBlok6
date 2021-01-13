package week6.vraag1;

import java.util.*;

class Graph {
    public static void makeGraph(ArrayList<ArrayList<String>> genes) {
        ArrayList<String> header = new ArrayList<>(genes.get(0));
        ArrayList<String> seq = new ArrayList<>(genes.get(1));
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
                        char pos1 = x.charAt(x.length() / 2 + k);
                        char pos2 = y.charAt(k);
                        if (pos1 == pos2) {
                            count++;
                        }
                    }
                }
                if (!header.get(i).equals(header.get(j)) && count > 1) {
                    out += (header.get(i) + " overlaps with " + header.get(j) + "\n");
                }
                count = 0;
            }
        }
        System.out.println(out);
    }
}
