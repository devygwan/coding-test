package tech.d2024.d12_1;

import java.util.Scanner;

public class N1475 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = String.valueOf(scanner.nextInt());
        int answer = 1;
        int[] numCnt = new int[10];

        for (char c : num.toCharArray()) {
            int targetNum = Integer.parseInt(String.valueOf(c));
            numCnt[targetNum]++;

            if (targetNum == 6 || targetNum == 9) {
                if (numCnt[6] + numCnt[9] > answer * 2) {
                    answer++;
                }
                continue;
            }

            if (numCnt[targetNum] > answer) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
