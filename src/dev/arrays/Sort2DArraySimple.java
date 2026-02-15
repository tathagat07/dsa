package dev.arrays;

import java.util.*;

public class Sort2DArraySimple {
    public static int[] sort2DArray(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n * n];

        // Flatten into 1D array
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[idx++] = matrix[i][j];
            }
        }

        // Sort 1D array
        Arrays.sort(result);
        return result;
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
    }
}

