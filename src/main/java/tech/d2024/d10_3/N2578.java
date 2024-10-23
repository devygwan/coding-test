package tech.d2024.d10_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[5][5];

        for (int row = 0; row < 5; row++) {
            st = new StringTokenizer(reader.readLine());

            for (int col = 0; col < 5; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                changeBingoNumZero(board, num);

                int bingoCount = countRLCheck(board) + countRLDiagCheck(board);

                if (bingoCount >= 3) {
                    System.out.println(answer);
                    System.exit(0);
                }

                answer++;
            }
        }
    }

    private static void changeBingoNumZero(int[][] board, int num) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board[row][col] == num) {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static int countRLCheck(int[][] board) {
        int bingoCount = 0;

        for (int row = 0; row < 5; row++) {
            int rCount = 0;
            int cCount = 0;

            for (int col = 0; col < 5; col++) {
                if (board[row][col] == 0) {
                    rCount++;
                }

                if (board[col][row] == 0) {
                    cCount++;
                }
            }

            if (rCount == 5) {
                bingoCount++;
            }

            if (cCount == 5) {
                bingoCount++;
            }
        }

        return bingoCount;
    }

    public static int countRLDiagCheck(int[][] board) {
        int bingoCount = 0;
        boolean isRDiag = true;
        boolean isLDiag = true;

        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) {
                isRDiag = false;
                break;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != 0) {
                isLDiag = false;
                break;
            }
        }

        if (isRDiag) {
            bingoCount++;
        }

        if (isLDiag) {
            bingoCount++;
        }

        return bingoCount;
    }
}
