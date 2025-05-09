package tech.d2025.d4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    private static int n;
    private static int m;
    private static int[] dirX = {0, 0, 1, -1};
    private static int[] dirY = {1, -1, 0, 0};
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            String line = reader.readLine();
            for (int col = 0; col < m; col++) {
                board[row][col] = line.charAt(col) - '0';
            }
        }
        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 1});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int count = current[2];

            if (row == n - 1 && col == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirX[i];
                int newCol = col + dirY[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    if (!visited[newRow][newCol] && board[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}
