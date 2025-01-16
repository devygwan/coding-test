package tech.d2025.d1_2;

import java.util.*;

public class N2503 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> hints = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String hint = scanner.nextLine();
            hints.add(hint);
        }

        int answer = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    String target = String.valueOf(i * 100 + j * 10 + k);
                    int count = 0;

                    for (String hint : hints) {
                        if (isAnswer(target, hint)) {
                            count++;
                        }
                    }

                    if (count == n) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
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