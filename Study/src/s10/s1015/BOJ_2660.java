package s10.s1015;

import java.io.*;
import java.util.*;

public class BOJ_2660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        // 친구
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        
        // 친구 관계 -> 회원 점수 
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] score = new int[N+1];
        int minScore = Integer.MAX_VALUE;  // 회장 - 점수가 가장 작은 사람
        
        // 최종 각 회원 점수
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    score[i] = Math.max(score[i], dist[i][j]);
                }
            }
            System.out.println(score[i]);
            minScore = Math.min(minScore, score[i]);
        }
        
        // 회장 후보 리스트 
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == minScore) {
            	lst.add(i);
            }
        }

        System.out.println(minScore + " " + lst.size());
        for (int i=0;i<lst.size();i++) {
            System.out.print(lst.get(i) + " ");
        }
    }
}
