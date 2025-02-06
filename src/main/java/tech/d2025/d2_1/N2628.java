package tech.d2025.d2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int round = Integer.parseInt(reader.readLine());

        List<Integer> rowCut = new ArrayList<>();
        List<Integer> colCut = new ArrayList<>();

        rowCut.add(0);
        colCut.add(0);
        rowCut.add(row);
        colCut.add(col);

        for (int i = 0; i < round; i++) {
            st = new StringTokenizer(reader.readLine());

            if (Integer.parseInt(st.nextToken()) == 0) {
                rowCut.add(Integer.parseInt(st.nextToken()));
            } else {
                colCut.add(Integer.parseInt(st.nextToken()));
            }
        }

        rowCut.sort(Integer::compareTo);
        colCut.sort(Integer::compareTo);

        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rowCut.size() - 1; i++) {
            maxRow = Math.max(maxRow, rowCut.get(i + 1) - rowCut.get(i));
        }

        for (int i = 0; i < colCut.size() - 1; i++) {
            maxCol = Math.max(maxCol, colCut.get(i + 1) - colCut.get(i));
        }

        System.out.println(maxRow * maxCol);
    }
}
