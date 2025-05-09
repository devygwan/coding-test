package tech.d2025.d5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        List<Integer> truthList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            truthList.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < p; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
            parties.add(party);
        }

        Set<Integer> truthRoots = new HashSet<>();

        for (int person : truthList) {
            truthRoots.add(find(person));
        }

        int answer = 0;

        for (List<Integer> party : parties) {
            boolean canLie = true;

            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
}
