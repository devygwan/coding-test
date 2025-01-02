package tech.d2024.d12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16439 {
    private static int n;
    private static int m;
    private static int max = 0;
    private static int[][] chicken;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[m];
        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int depth, int start) {
        if (depth == 3) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int maxPriority = 0;
                for (int j = 0; j < m; j++) {
                    if (visited[j]) {
                        maxPriority = Math.max(maxPriority, chicken[i][j]);
                    }
                }
                sum += maxPriority;
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, start + 1);
                visited[i] = false;
            }
        }
    }
}
