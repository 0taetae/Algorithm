package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_2461 {

    static int N, M;
    static int[][] score;

    static class Info implements Comparable<Info> {
        int score, row, col;
        
        Info(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }
        
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.score, o.score); 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score[i]);  // 각 학급의 학생들의 능력치를 오름차순 정렬 
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        int maxScore = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            pq.add(new Info(i, 0, score[i][0]));  // 작은 수부터 탐색 
            maxScore = Math.max(maxScore, score[i][0]); 
        }
        
        int minDif = Integer.MAX_VALUE; 
        
        while (true) {
            Info cur = pq.poll();
            
            minDif = Math.min(minDif, maxScore - cur.score);  // 최댓값과 최솟값의 차이가 최소가 되는 경우의 값 구하기 
            
            if(cur.col+1 >= M) break;
            
            int nextScore = score[cur.row][cur.col + 1];  // 해당 학급의 다음 수 
            pq.add(new Info(cur.row, cur.col + 1, nextScore));  // 해당 학급의 다음 대표 
            maxScore = Math.max(maxScore, nextScore);   // 최댓값 찾기 
        }

        System.out.println(minDif);
    }
}
