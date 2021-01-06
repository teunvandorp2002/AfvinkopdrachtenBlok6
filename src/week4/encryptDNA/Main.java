package week4.encryptDNA;

import static week4.encryptDNA.Encode.*;

public class Main {
    public static void main(String[] args) {
        String seq = "tatgccaatgcatttttgcccgcatgaagcatgtagcgcgcatgcctacctgcacgc";
        System.out.println(seq);
        String encodedDNAEncode = encodeDNA(seq);
        System.out.println(encodedDNAEncode);
        System.out.println(decodeDNA(encodedDNAEncode));
    }
}
