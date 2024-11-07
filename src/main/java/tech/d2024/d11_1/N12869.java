package tech.d2024.d11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N12869 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        PriorityQueue<Integer> scv = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            scv.add(Integer.parseInt(st.nextToken()));
        }

        int[] round = new int[]{9, 3, 1};

        int count = 0;

        while (!scv.isEmpty()) {
            int finalStage = Math.min(scv.size(), 3);
            Queue<Integer> readyQueue = new LinkedList<>();

            for (int stage = 0; stage < finalStage; stage++) {
                Integer target = scv.poll();
                readyQueue.add(target - round[stage]);
            }

            for (int k : readyQueue) {
                if (k > 0) {
                    scv.add(k);
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
