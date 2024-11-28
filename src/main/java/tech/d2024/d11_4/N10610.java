package tech.d2024.d11_4;

import java.util.Arrays;
import java.util.Scanner;

public class N10610 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        int sum = 0;
        boolean isHaveZero = false;

        for (char c : input) {
            int num = Character.getNumericValue(c);
            sum += num;

            if (num == 0) {
                isHaveZero = true;
            }
        }

        if (sum % 3 == 0 && isHaveZero) {
            Arrays.sort(input);

            for (int i = input.length - 1; i >= 0; i--) {
                System.out.print(input[i]);
            }
            return;
        }

        System.out.println(-1);
    }
}
