package week4.encryptDNA;

public class Encode {
    public static String encodeDNA(String sequence) {
        sequence = sequence.toLowerCase();
        sequence = sequence.replace("a", "11");
        sequence = sequence.replace("t", "10");
        sequence = sequence.replace("c", "01");
        sequence = sequence.replace("g", "00");
        return sequence;
    }
    
    public static String decodeDNA(String encoded) {
        String seq = "";
        for (int i = 0; i < encoded.length(); i += 2) {
            char first = encoded.charAt(i);
            char second = encoded.charAt(i + 1);
            if (first == '1' && second == '1') {
                seq += "a";
            } else if (first == '1' && second == '0') {
                seq += "t";
            } else if (first == '0' && second == '1') {
                seq += "c";
            } else if (first == '0' && second == '0') {
                seq += "g";
            }
        }
        return seq;
    }
}
