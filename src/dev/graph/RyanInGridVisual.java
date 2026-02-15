package dev.graph;

import java.util.*;

public class RyanInGridVisual {
    static int M, N;
    static char[][] grid;
    static int[][] breakCount;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean canReach(int sx, int sy, int dxTarget, int dyTarget) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[M][N];
        breakCount = new int[M][N];

        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            // mark Ryan's current position
            if (grid[x][y] == '.') {
                grid[x][y] = '>';
            }

            printGrid(sx, sy, dxTarget, dyTarget);

            if (x == dxTarget && y == dyTarget) {
                return true;
            }

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
                    if (breakCount[nx][ny] > 1 && !visited[nx][ny]) {
                        grid[nx][ny] = 'B'; // show breaking
                        printGrid(sx, sy, dxTarget, dyTarget);
                        grid[nx][ny] = '.'; // now it's free
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }

    // Function to print grid state
    public static void printGrid(int sx, int sy, int dxTarget, int dyTarget) {
        System.out.println("Current Grid State:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == sx && j == sy) {
                    System.out.print("S ");
                } else if (i == dxTarget && j == dyTarget) {
                    System.out.print("D ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------");
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

        int sx = sc.nextInt() - 1;
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
