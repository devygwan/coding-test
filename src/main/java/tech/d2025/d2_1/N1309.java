package tech.d2025.d2_1;

import java.util.Scanner;

public class N1309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 3;

        for(int i  = 2; i < n + 1; i++) {
            dp[i] = 2 * dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n] % 9901);
    }
}
