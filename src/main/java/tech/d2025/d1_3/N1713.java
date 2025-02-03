package tech.d2025.d1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Student> photos = new ArrayList<>();
        Student[] students = new Student[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 사진 추가
            if (students[num] != null) {
                students[num].count++;
            } else {
                // 정렬
                Collections.sort(photos);

                if (photos.size() == n) {
                    // 사진 삭제
                    Student del = photos.remove(n - 1);
                    students[del.num] = null;
                }

                // 새로운 학생
                students[num] = new Student(num, 1, i);
                photos.add(students[num]);
            }
        }

        // photos 출력
        photos.sort(Comparator.comparingInt(o -> o.num));

        for (Student s : photos) {
            System.out.print(s.num + " ");
        }
    }
}

class Student implements Comparable<Student> {
    int num;
    int count;
    int time;

    public Student(int num, int count, int time) {
        this.num = num;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(Student s2) {
        int resultCnt = s2.count - count;
        if (resultCnt == 0) {
            return s2.time - time;
        }
        return resultCnt;
    }
}

