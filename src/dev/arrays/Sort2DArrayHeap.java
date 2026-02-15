package dev.arrays;

import java.util.*;

public class Sort2DArrayHeap {
    static class Node {
        int value, row, col;
        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static int[] sort2DArray(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n * n];

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        // Insert first element of each row into the heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Node(matrix[i][0], i, 0));
        }

        int idx = 0;
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result[idx++] = curr.value;

            // If there's a next element in the same row, add it
            if (curr.col + 1 < n) {
                minHeap.offer(new Node(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return result;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];

            if (val == target) {
                return true; // Return immediately when found
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false; // Not found
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };

      //  int[] sorted = sort2DArray(matrix);
         System.out.println(searchMatrix(matrix,3));
        // Print sorted array
  //      System.out.println(Arrays.toString(sorted));
    }
}
