package tech.d2024.d10_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18428 {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean isResult = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(reader.readLine());

        char[][] map = new char[n][n];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(reader.readLine());

            for (int col = 0; col < n; col++) {
                map[row][col] = st.nextToken().charAt(0);
            }
        }

        recursive(0, n, map);

        if (isResult) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void recursive(int i, int n, char[][] map) {
        if (i == 3) {
            boolean isSuccess = true;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (map[row][col] != 'T') {
                        continue;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int x = row;
                        int y = col;

                        while(true) {
                            x = x + dx[dir];
                            y = y + dy[dir];

                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                break;
                            }

                            if (map[x][y] == '0') {
                                break;
                            }

                            if (map[x][y] == 'S') {
                                isSuccess = false;
                            }
                        }
                    }
                }
            }

            if (isSuccess) {
                isResult = true;
            }

            return;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] == 'X') {
                    map[x][y] = '0';
                    recursive(i + 1, n, map);
                    map[x][y] = 'X';
                }
            }
        }
    }
}
