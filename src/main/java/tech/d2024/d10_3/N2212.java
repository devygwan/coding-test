package tech.d2024.d10_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int[] points = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        PriorityQueue<Integer> intervals = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            intervals.add(points[i + 1] - points[i]);
        }

        int totalLength = points[points.length - 1] - points[0];
        int maxIntervalLength = 0;

        for(int count = 0; count < k-1; count++) {
            maxIntervalLength += intervals.poll();
        }

        System.out.println(totalLength - maxIntervalLength);
    }
}
