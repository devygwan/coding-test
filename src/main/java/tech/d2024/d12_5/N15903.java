package tech.d2024.d12_5;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class N15903 {

    public static void main(String[] args) {
        Queue<Long> queue = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int round = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextLong());
        }

        for (int i = 0; i < round; i++) {
            Long a = queue.poll();
            Long b = queue.poll();

            long sum = a + b;
            queue.add(sum);
            queue.add(sum);
        }

        Long result = 0L;

        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        System.out.println(result);
    }
}
