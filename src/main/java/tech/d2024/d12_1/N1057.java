package tech.d2024.d12_1;

import java.util.Scanner;

public class N1057 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int kjm = scanner.nextInt();
        int lhs = scanner.nextInt();
        int round = 0;

        while (true) {
            if (kjm == lhs) {
                break;
            }

            kjm = kjm / 2 + kjm % 2;
            lhs = lhs / 2 + lhs % 2;
            round++;
        }

        System.out.println(round);
    }
}
