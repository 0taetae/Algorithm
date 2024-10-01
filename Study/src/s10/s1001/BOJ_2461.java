package s10.s1001;

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
        public int compareTo(Info o) {  // 오름차순
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
            Arrays.sort(score[i]);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        int maxScore = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            pq.add(new Info(i, 0, score[i][0]));
            maxScore = Math.max(maxScore, score[i][0]); 
        }
        
        int minDif = Integer.MAX_VALUE; 
        
        while (true) {
            Info cur = pq.poll();
            int minScore = cur.score;
            
            minDif = Math.min(minDif, maxScore - minScore);
            
            if (cur.col + 1 < M) {
                int nextScore = score[cur.row][cur.col + 1];
                pq.add(new Info(cur.row, cur.col + 1, nextScore));
                maxScore = Math.max(maxScore, nextScore); 
            } else {
                break;
            }
        }

        System.out.println(minDif);
    }
}
