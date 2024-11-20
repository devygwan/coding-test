package tech.d2024.d11_3;

import java.util.Scanner;

public class N1436 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = findNum(n);
        System.out.println(num);
    }

    private static int findNum(int n) {
        int count = 0;
        int num = 666;

        while (true) {
            String targetNum = String.valueOf(num);

            if (targetNum.contains("666")) {
                count++;
            }

            if (count == n) {
                return num;
            }

            num++;
        }
    }
}
