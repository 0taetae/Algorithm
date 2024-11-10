package s11.s1110;

import java.io.*;
import java.util.*;

public class BOJ_2239 {

    static int[][] map = new int[9][9];
    static boolean[][] visitedR = new boolean[9][10]; // 행 방문 배열
    static boolean[][] visitedC = new boolean[9][10]; // 열 방문 배열
    static boolean[][][] visited33 = new boolean[3][3][10]; // 3*3 방문 배열
    static boolean isFinished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 입력
        for (int r = 0; r < 9; r++) {
            String str = br.readLine();
            for (int c = 0; c < 9; c++) {
                map[r][c] = str.charAt(c) - '0';
                if (map[r][c] != 0) {
                    visitedR[r][map[r][c]] = true;
                    visitedC[c][map[r][c]] = true;
                    visited33[r/3][c/3][map[r][c]] = true;
                }
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int r, int c) {
        if (isFinished) {
            return;
        }

        if (c >= 9) {
            r++;
            c = 0;
        }

        if (r >= 9) {
            isFinished = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            return;
        }

        // 숫자가 채워지지 않은 칸
        if (map[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!visitedR[r][i] && !visitedC[c][i] && !visited33[r/3][c/3][i]) {
                    map[r][c] = i;
                    visitedR[r][i] = true;
                    visitedC[c][i] = true;
                    visited33[r/3][c/3][i] = true;

                    dfs(r, c + 1);

                    map[r][c] = 0;
                    visitedR[r][i] = false;
                    visitedC[c][i] = false;
                    visited33[r/3][c/3][i] = false;
                }
            }
        } else {
            dfs(r, c + 1);
        }
    }
}