package tech.d2024.d11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3184 {

    private static int r, c;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};
    private static char[][] garden;
    private static boolean[][] visited;
    private static int sheepCnt, wolfCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        garden = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            garden[i] = reader.readLine().toCharArray();
        }

        int aliveSheepCnt = 0;
        int aliveWolfCnt = 0;

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (visited[x][y]) {
                    continue;
                }

                if (garden[x][y] == '.' || garden[x][y] == '#') {
                    continue;
                }

                sheepCnt = 0;
                wolfCnt = 0;
                dfs(x, y);

                if (sheepCnt > wolfCnt) {
                    aliveSheepCnt += sheepCnt;
                } else {
                    aliveWolfCnt += wolfCnt;
                }
            }
        }

        System.out.println(aliveSheepCnt);
        System.out.println(aliveWolfCnt);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (garden[x][y] == 'v') {
            wolfCnt++;
        }
        if (garden[x][y] == 'o') {
            sheepCnt++;
        }

        int nextX;
        int nextY;

        for (int i = 0; i < 4; i++) {
            nextX = x + dirX[i];
            nextY = y + dirY[i];

            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
                continue;
            }

            if (visited[nextX][nextY] || garden[nextX][nextY] == '#') {
                continue;
            }

            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
    }
}
