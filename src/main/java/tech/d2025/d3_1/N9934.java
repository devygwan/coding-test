package tech.d2025.d3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N9934 {

    private static int size;
    private static ArrayList<String>[] tree;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());

        st = new StringTokenizer(reader.readLine());

        size = (int) Math.pow(2, k) - 1;
        tree = new ArrayList[k];

        for (int i = 0; i < k; i++) {
            tree[i] = new ArrayList<>();
        }

        inOrder(1, 0);

        for (int i = 0; i < k; i++) {
            for (String a : tree[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void inOrder(int node, int depth) {
        if (node > size) return;
        inOrder(node * 2, depth + 1);
        tree[depth].add(st.nextToken());
        inOrder(node * 2 + 1, depth + 1);
    }
}
