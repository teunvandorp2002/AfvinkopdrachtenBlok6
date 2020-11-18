package week1;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static int[] ints;

    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("Creating Array...   ");
        ints = new int[1000000];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000000000);
        }
        System.out.println("[v]");
        System.out.print("Sorting...   ");
        long startTime = System.currentTimeMillis();
        mergeSort(0, ints.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("[v]");

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(ints));
        System.out.printf("String sorted in %s [minutes:seconds]%n",
                Time.getElapsedTime(endTime - startTime));
    }

    // Recursive algorithm for merge sort
    public static void mergeSort(int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            // Sort left half
            mergeSort(start, mid);
            // Sort right half
            mergeSort(mid + 1, end);
            // Merge left and right half
            merge(start, mid, end);
        }

    }


    private static void merge(int start, int mid, int end) {
        // Initializing temp array and index
        int[] tempArray = new int[ints.length];
        int tempArrayIndex = start;

        int startIndex = start;
        int midIndex = mid + 1;

        // It will iterate until smaller list reaches to the end
        while (startIndex <= mid && midIndex <= end) {
            if (ints[startIndex] < ints[midIndex]) {
                tempArray[tempArrayIndex++] = ints[startIndex++];
            } else {
                tempArray[tempArrayIndex++] = ints[midIndex++];
            }
        }

        // Copy remaining elements
        while (startIndex <= mid) {
            tempArray[tempArrayIndex++] = ints[startIndex++];
        }
        while (midIndex <= end) {
            tempArray[tempArrayIndex++] = ints[midIndex++];
        }

        // Copy tempArray to actual array after sorting
        for (int i = start; i <= end; i++) {
            ints[i] = tempArray[i];
        }

    }

}
