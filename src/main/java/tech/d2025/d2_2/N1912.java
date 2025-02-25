package tech.d2025.d2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n + 1];
        int[] sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        sum[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum[i] = nums[i] + sum[i - 1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                max = Math.max(max, sum[j] - sum[i]);
            }
        }

        System.out.println(max);
    }
}
