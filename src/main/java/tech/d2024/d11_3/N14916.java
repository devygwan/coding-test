package tech.d2024.d11_3;

import java.util.Scanner;

public class N14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = calChange(n);
        System.out.println(answer);
    }

    private static int calChange(int n) {
        int count = 0;

        if (n % 5 == 0) {
            return n / 5;
        } else {
            while (n > 0) {
                if (n % 5 == 0) {
                    return count + n / 5;
                } else {
                    n = n - 2;
                    count++;
                }

                if (n == 0) {
                    return count;
                }
            }

            return -1;
        }
    }
}
