package s10.s1031;

import java.io.*;
import java.util.*;

public class SWEA_6808 {

    static int[] select;
    static int[] person2, person1;
    static boolean[] used;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[19];
            person1 = new int[9]; // 규영 카드
            person2 = new int[9]; // 인영 카드
            select = new int[9];
            used = new boolean[9];
            win = 0;
            lose = 0;

            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                visited[num] = true;
                person1[i] = num;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!visited[i]) {
                    person2[idx] = i;
                    idx++;
                }
            }
            perm(0);
            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    public static void perm(int cnt) {
        if (cnt == 9) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 9; i++) {
                if (person1[i] > select[i]) {
                    sum1 += person1[i] + select[i];
                } else {
                    sum2 += person1[i] + select[i];
                }
            }
            if (sum1 > sum2) {
                win++;
            } else if (sum1 < sum2) {
                lose++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                select[cnt] = person2[i];
                perm(cnt + 1);
                used[i] = false;
            }
        }
    }
}
