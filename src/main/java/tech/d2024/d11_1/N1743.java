package tech.d2024.d11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1743 {

    private static int[] dirX = new int[]{-1, 1, 0, 0};
    private static int[] dirY = new int[]{0, 0, -1, 1};
    private static int trashSize = 0;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] paths = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            paths[x][y] = true;
        }

        int maxTrashSize = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (paths[x][y]) {
                    search(x, y, paths);
                    maxTrashSize = Integer.max(maxTrashSize, trashSize);
                    trashSize = 0;
                }
            }
        }

        System.out.println(maxTrashSize);
    }

    private static void search(int x, int y, boolean[][] paths) {
        paths[x][y] = false;
        trashSize++;

        for (int i = 0; i < 4; i++) {
            int xPoint = x + dirX[i];
            int yPoint = y + dirY[i];

            if (xPoint >= 0 && yPoint >= 0 && xPoint < n && yPoint < m) {
                if (paths[xPoint][yPoint]) {
                    search(xPoint, yPoint, paths);
                }
            }
        }
    }
}
