package patternbased.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;
        for(int city = 0; city < n; city++){
            if(!visited[city]){
                bfs(city,isConnected,visited);
                provinces++;
            }
        }
      return provinces;
    }

    private void bfs(int start, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int city = queue.poll();
            for(int neighbour = 0 ; neighbour < isConnected.length ; neighbour++){
                if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solver = new NumberOfProvinces();

        // Test Case 1: Cities 0 and 1 are connected; City 2 is separate.
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // Test Case 2: No cities are connected to each other.
        int[][] isConnected2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println("Test Case 1:");
        System.out.println("Matrix:");
        for (int[] row : isConnected1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Provinces: " + solver.findCircleNum(isConnected1));

        System.out.println("\nTest Case 2:");
        System.out.println("Matrix:");
        for (int[] row : isConnected2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Provinces: " + solver.findCircleNum(isConnected2));
    }
}
