package tech.d2025.d1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1531 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[][] picture = new int[101][101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    picture[x][y] = picture[x][y] + 1;
                }
            }
        }

        int count = 0;

        for(int x = 1; x <= 100; x++) {
            for(int y = 1; y <= 100; y++) {
                if(picture[x][y] > m) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
