package week1;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    static int[] ints;
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Random random = new Random();
        ints = new int[1000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000000000);
        }
        long start = System.currentTimeMillis();
        sort.quick_sort(ints, 0, ints.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(ints));
        System.out.println("Sorted in: " + (end - start) + " milliseconds");
    }
}
