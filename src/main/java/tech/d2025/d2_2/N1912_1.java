package tech.d2025.d2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
