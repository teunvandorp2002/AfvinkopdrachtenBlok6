package week1;

import java.util.Random;

public class Graphing {
    static int[] ints;

    public static void main(String[] args) {
        Random random = new Random();
        QuickSort sort = new QuickSort();
        Files.create("resultsWeek1.tsv");
        Files.write("resultsWeek1.tsv", "List size\tTime (ms)");
        int length = 1;
        for (int j = 0; j < 25; j++) {
            ints = new int[length];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = random.nextInt(1000000000);
            }
            long startTime = System.currentTimeMillis();
            sort.quick_sort(ints, 0, ints.length - 1);
            long endTime = System.currentTimeMillis();
            System.out.print(length + "\t");
            System.out.println(endTime - startTime);
            Files.append("resultsWeek1.tsv", String.format("%s\t%s", length, endTime - startTime));
            length *= 2;
        }
    }


}
