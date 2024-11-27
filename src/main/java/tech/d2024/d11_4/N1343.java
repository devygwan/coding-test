package tech.d2024.d11_4;

import java.util.Scanner;

public class N1343 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String board = scanner.nextLine();

        String firstReplace = board.replace("XXXX", "AAAA");
        String result = firstReplace.replace("XX", "BB");

        if (result.contains("X")) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
        scanner.close();
    }
}
