package tech.d2025.d1_1;

import java.util.Scanner;

public class N3085 {

    private static int N;
    private static char[][] board;
    private static int maxCount = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        board = new char[N][N];

        for (int row = 0; row < N; row++) {
            String line = sc.nextLine();
            for (int col = 0; col < N; col++) {
                board[row][col] = line.charAt(col);
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N - 1; col++) {
                char first = board[row][col];
                char second = board[row][col + 1];

                if (first != second) {
                    swapCol(row, col, col + 1);
                    search();
                    swapCol(row, col + 1, col);
                }
            }
        }

        for (int row = 0; row < N - 1; row++) {
            for (int col = 0; col < N; col++) {
                char first = board[row][col];
                char second = board[row + 1][col];

                if (first != second) {
                    swapRow(col, row, row + 1);
                    search();
                    swapRow(col, row + 1, row);
                }
            }
        }

        System.out.println(maxCount);
    }

    private static void swapCol(int row, int firstCol, int secondCol) {
        char temp = board[row][firstCol];
        board[row][firstCol] = board[row][secondCol];
        board[row][secondCol] = temp;
    }

    private static void swapRow(int col, int firstRow, int secondRow) {
        char temp = board[firstRow][col];
        board[firstRow][col] = board[secondRow][col];
        board[secondRow][col] = temp;
    }

    private static void search() {
        for (int row = 0; row < N; row++) {
            int count = 1;

            for (int col = 0; col < N - 1; col++) {
                if (board[row][col] == board[row][col + 1]) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    count = 1;
                }
            }
        }

        for (int row = 0; row < N; row++) {
            int count = 1;

            for (int col = 0; col < N - 1; col++) {
                if (board[col][row] == board[col + 1][row]) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    count = 1;
                }
            }
        }
    }
}
