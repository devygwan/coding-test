package tech.d2024.d11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1133 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n + 1];
        int[] answer = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int j = 1;

            while (true) {
                if (arr[i] == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                } else if (answer[j] == 0) {
                    arr[i]--;
                }

                j++;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
