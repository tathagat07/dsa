package dev.graph;

import java.util.*;

public class RyanInGrid {
    static int M, N;
    static char[][] grid;
    static int[][] breakCount; // tracks how many sides touched a hollow block
    static boolean[][] visited;

    // Directions: up, down, left, right
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean canReach(int sx, int sy, int dxTarget, int dyTarget) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[M][N];
        breakCount = new int[M][N];

        // Start BFS from source
        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            // If destination reached
            if (x == dxTarget && y == dyTarget) {
                return true;
            }

            // Explore neighbors
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if (grid[nx][ny] == '.') {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                } else if (grid[nx][ny] == '*') {
                    breakCount[nx][ny]++;

                    // If block can be broken now
                    if (breakCount[nx][ny] > 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        grid = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = sc.nextLine().trim();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int sx = sc.nextInt() - 1; // convert to 0-based
        int sy = sc.nextInt() - 1;
        int dxTarget = sc.nextInt() - 1;
        int dyTarget = sc.nextInt() - 1;

        if (canReach(sx, sy, dxTarget, dyTarget)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
