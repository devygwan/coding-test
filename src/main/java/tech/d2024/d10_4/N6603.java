package tech.d2024.d10_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6603 {

    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String context = reader.readLine();

        while (!context.equals("0")) {
            st = new StringTokenizer(context);

            int k = Integer.parseInt(st.nextToken());
            int[] s = new int[k];
            boolean[] visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(s);

            permutation(0, 0, s, visited);
            result.append("\n");

            context = reader.readLine();
        }

        System.out.println(result);
    }

    private static void permutation(int index, int depth, int[] s, boolean[] visited) {
        if (depth == 6) {
            for (int i = 0; i < s.length; i++) {
                if (visited[i]) {
                    result.append(s[i]).append(" ");
                }
            }
            result.append("\n");
        }

        for (int i = index; i < s.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(i + 1, depth + 1, s, visited);
                visited[i] = false;
            }
        }
    }
}
