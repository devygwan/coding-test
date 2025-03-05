package tech.d2025.d2_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N2503_1 {

    private static List<String> hints = new ArrayList<>();
    private static int N;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            hints.add(sc.nextLine());
        }

        boolean[] used = new boolean[10];
        findValidNumbers("", used);

        System.out.println(answer);
    }

    private static void findValidNumbers(String num, boolean[] used) {
        if (num.length() == 3) {
            int count = 0;

            for (String hint : hints) {
                if (isAnswer(num, hint)) {
                    count++;
                }
            }

            if (count == N) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                findValidNumbers(num + i, used);
                used[i] = false;
            }
        }
    }

    public static boolean isAnswer(String target, String hint) {
        int strikeCnt = 0;
        int ballCnt = 0;

        String[] hintArray = hint.split(" ");
        String hintNum = hintArray[0];

        for (int i = 0; i < 3; i++) {
            if (target.charAt(i) == hintNum.charAt(i)) {
                strikeCnt++;
            } else if (target.contains(String.valueOf(hintNum.charAt(i)))) {
                ballCnt++;
            }
        }

        int hintStrikeCnt = Integer.parseInt(hintArray[1]);
        int hintBallCnt = Integer.parseInt(hintArray[2]);

        return strikeCnt == hintStrikeCnt && ballCnt == hintBallCnt;
    }
}

