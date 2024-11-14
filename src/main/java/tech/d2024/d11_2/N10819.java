package tech.d2024.d11_2;

import java.util.Scanner;

public class N10819 {

    private static int result;
    private static int n;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];
        int[] numbers = new int[n];
        permutation(0, numbers, visited);

        System.out.println(result);
    }

    public static void permutation(int depth, int[] numbers, boolean[] visited) {
        if (depth == n) {
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numbers[depth] = nums[i];
                visited[i] = true;
                permutation(depth+1, numbers, visited);
                visited[i] = false;
            }
        }
    }
}
