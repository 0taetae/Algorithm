package s10.s1010;

import java.io.*;
import java.util.*;

public class BOJ_2458_sol2 {

    static int N, M;
    static boolean[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 학생 수
        M = Integer.parseInt(st.nextToken());  // 두 학생 키 비교 횟수
        dist = new boolean[N+1][N+1];  // 경로 정보 저장

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // a < b
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = true;  // a가 b보다 작음
        }

        // 플로이드-워샬 알고리즘: 모든 정점 간의 경로 정보 갱신
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;  // i가 k를 거쳐 j보다 작다면, i < j
                    }
                }
            }
        }

        int res = 0;

        // 각 학생에 대해 자신보다 큰 사람과 작은 사람의 수를 계산
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && (dist[i][j] || dist[j][i])) {
                    cnt++;
                }
            }

            // 자신보다 크거나 작은 사람이 총 N-1명이면 순서를 정확히 알 수 있음
            if (cnt == N - 1) {
                res++;
            }
        }

        System.out.println(res);
    }
}
