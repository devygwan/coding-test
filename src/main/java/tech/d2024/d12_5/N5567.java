package tech.d2024.d12_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N5567 {

    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        StringTokenizer st;

        graph = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n + 1];

        visited[1] = true;
        dfs(1, 0);

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int num, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i : graph.get(num)) {
            visited[i] = true;
            dfs(i, depth + 1);
        }
    }
}
