package dev.arrays;

import java.util.Arrays;

public class Sort2DArrayHeapStream {
    public static int[] sort2DArray(int[][] matrix) {
        return Arrays.stream(matrix) // Stream each row of the matrix
                .flatMapToInt(Arrays::stream) // Flatten the 2D array into a 1D stream
                .sorted() // Sort the stream
                .toArray(); // Convert the sorted stream to an array
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {12, 22, 32, 42},
                {15, 25, 35, 45},
                {17, 27, 37, 47}
        };

        int[] sorted = sort2DArray(matrix);

        // Print sorted array
        System.out.println(Arrays.toString(sorted));
        System.out.println("Sorted array length: " + sorted.length);
    }
}