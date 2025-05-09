package tech.d2025.d5_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = Integer.MAX_VALUE / 2;
        int[] dp = new int[c + 1];

        for (int j = 1; j <= c; j++) {
            dp[j] = maxValue;
        }

        dp[0] = 0;
        for (int j = 0; j <= c; j++) {
            if (dp[j] == maxValue) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                int nxt = j + people[i];

                if (nxt > c) {
                    nxt = c;
                }

                dp[nxt] = Math.min(dp[nxt], dp[j] + cost[i]);
            }
        }

        System.out.println(dp[c]);
    }
}
