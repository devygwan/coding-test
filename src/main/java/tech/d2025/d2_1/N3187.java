package tech.d2025.d2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3187 {

    private static int r;
    private static int c;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {-0, 0, -1, 1};
    private static char[][] board;
    private static boolean[][] visited;
    private static int sheep;
    private static int wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = reader.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int totalSheep = 0;
        int totalWolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != '#' && !visited[i][j]) {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        System.out.println(totalSheep);
        System.out.println(totalWolf);
    }

    private static void dfs(int i, int j) {
        if (board[i][j] == 'k') {
            sheep++;
        }

        if (board[i][j] == 'v') {
            wolf++;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && board[nx][ny] != '#') {
                dfs(nx, ny);
            }
        }
    }
}
