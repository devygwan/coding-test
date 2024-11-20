package tech.d2024.d11_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(reader.readLine());

            for (int index = 0; index < n; index++) {
                queue.add(new int[]{index, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (true) {
                int[] values = queue.poll();
                boolean isMaxValue = true;

                for (int[] q : queue) {
                    if (values[1] < q[1]) {
                        isMaxValue = false;
                        break;
                    }
                }

                if (isMaxValue) {
                    count++;
                    if (values[0] == m) {
                        result.append(count).append("\n");
                        break;
                    }
                } else {
                    queue.add(values);
                }
            }
        }

        System.out.println(result);
    }
}
