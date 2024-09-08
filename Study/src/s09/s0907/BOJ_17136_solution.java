package s09.s0907;

import java.io.*;
import java.util.*;

public class BOJ_17136_solution {
    static int[][] paper; // 10x10 종이
    static int[] maxCnt = {0, 5, 5, 5, 5, 5}; // 각 크기별 남은 색종이 수
    static int result = Integer.MAX_VALUE; // 최소 색종이 개수
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        paper = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 탐색 시작
        solve(0, 0, 0);
        
        // 결과 출력
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1); // 모든 1을 덮을 수 없는 경우
        } else {
            System.out.println(result); // 최소 색종이 개수
        }
    }

    // (x, y)에서 시작하는 재귀 탐색
    static void solve(int x, int y, int count) {
        if (x >= 10) { // 끝까지 탐색 완료
            result = Math.min(result, count);
            return;
        }

        if (y >= 10) { // 한 줄이 끝나면 다음 줄로 이동
            solve(x + 1, 0, count);
            return;
        }

        if (paper[x][y] == 0) { // 0인 경우는 그냥 넘어감
            solve(x, y + 1, count);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (canAttach(x, y, size)) {
                attach(x, y, size, 0); // 색종이 붙이기
                maxCnt[size]--;      // 남은 색종이 개수 감소
                solve(x, y + 1, count + 1); // 다음 칸으로 이동
                attach(x, y, size, 1); // 다시 원상 복구
                maxCnt[size]++;      // 색종이 개수 복구
            }
        }
    }

    // (x, y) 위치에 size 크기의 색종이를 붙일 수 있는지 확인
    static boolean canAttach(int x, int y, int size) {
        if (maxCnt[size] == 0) return false; // 남은 색종이가 없으면 불가능
        if (x + size > 10 || y + size > 10) return false; // 종이 경계를 넘으면 불가능
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] == 0) return false; // 붙이는 공간에 0이 있으면 불가능
            }
        }
        return true;
    }

    // (x, y) 위치에 size 크기의 색종이를 붙이거나 떼기
    static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = state; // 색종이를 붙이면 0, 떼면 1로 변경
            }
        }
    }
}

