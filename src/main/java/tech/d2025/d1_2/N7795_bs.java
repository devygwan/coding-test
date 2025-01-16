package tech.d2025.d1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7795_bs {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            String str = reader.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] aList = new int[n];
            int[] bList = new int[m];

            st = new StringTokenizer(reader.readLine());

            for (int idx = 0; idx < n; idx++) {
                aList[idx] = (Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(reader.readLine());

            for (int idx = 0; idx < m; idx++) {
                bList[idx] = (Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(bList);

            result[i] = calc(aList, bList);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }

    private static int calc(int[] aList, int[] bList) {
        int result = 0;

        for (int target : aList) {
            int count = 0;
            int lowIndex = 0;
            int highIndex = bList.length - 1;

            while (lowIndex <= highIndex) {
                int midIndex = (lowIndex + highIndex) / 2;

                if(target > bList[midIndex]) {
                     lowIndex = midIndex + 1;
                     count = midIndex + 1;
                } else {
                    highIndex = midIndex - 1;
                }
            }
            result += count;
        }

        return result;
    }
}