package tech.d2025.d2_1;

import java.util.Scanner;

public class N2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stairPoints = new int[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            stairPoints[i] = sc.nextInt();
        }

        score[0] = stairPoints[0];

        if (n == 1) {
            System.out.println(score[0]);
            return;
        }

        score[1] = stairPoints[0] + stairPoints[1];

        if (n == 2) {
            System.out.println(score[1]);
            return;
        }

        score[2] = Math.max(stairPoints[0] + stairPoints[2], stairPoints[1] + stairPoints[2]);

        for (int i = 3; i < n; i++) {
            score[i] = Math.max(score[i - 3] + stairPoints[i - 1], score[i - 2]) + stairPoints[i];
        }

        System.out.println(score[n - 1]);
    }
}
