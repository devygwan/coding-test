package tech.d2024.d12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N5635 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());

        Map<Integer, String> members = new HashMap<>(n);
        List<Integer> births = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            String name = st.nextToken();

            StringBuilder birth = new StringBuilder();
            String day = String.format("%02d", Integer.parseInt(st.nextToken()));
            String month = String.format("%02d", Integer.parseInt(st.nextToken()));
            String year = String.format("%04d", Integer.parseInt(st.nextToken()));
            birth.append(year).append(month).append(day);

            int birthNum = Integer.parseInt(birth.toString());

            members.put(birthNum, name);
            births.add(birthNum);
        }

        Collections.sort(births);

        System.out.println(members.get(births.get(n-1)));
        System.out.println(members.get(births.get(0)));

    }
}