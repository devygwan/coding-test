package tech.d2024.d10_4;

import java.util.Scanner;

public class N8911 {

    private static final int[] dirX = {0, 1, 0, -1};
    private static final int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        int[] answer = new int[t];

        for (int round = 0; round < t; round++) {
            int minX = 0, minY = 0, maxX = 0, maxY = 0;
            int x = 0, y = 0;
            int dirIndex = 0;

            String line = scanner.nextLine();

            for (char c : line.toCharArray()) {
                if (c == 'L') {
                    dirIndex = getIndex(dirIndex - 1);
                }

                if (c == 'R') {
                    dirIndex = getIndex(dirIndex + 1);
                }

                if (c == 'F') {
                    x = x + dirX[dirIndex];
                    y = y + dirY[dirIndex];
                }

                if (c == 'B') {
                    x = x - dirX[dirIndex];
                    y = y - dirY[dirIndex];
                }

                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
            }

            answer[round] = (Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY));
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int getIndex(int num) {
        int index = num;

        while (index < 0) {
            index = 4 + index;
        }

        return index % 4;
    }
}
