package s09.s0919;

import java.io.*;
import java.util.*;

public class BOJ_14500 {
    
    static int N, M, res;
    static int[][] paper;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for(int r = 0; r < N; r++) {
        	st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        int sum=0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
            	// '-' 모양
            	if(c<=M-4) {
            		sum = paper[r][c] + paper[r][c+1] + paper[r][c+2] + paper[r][c+3];
            		res = Math.max(res, sum);
            	}
            	// '|' 모양
            	if(r<=N-4) {
            		sum = paper[r][c] + paper[r+1][c] + paper[r+2][c] + paper[r+3][c];
            		res = Math.max(res, sum);
            	}
            	// 'ㅁ' 모양
            	if(c<=M-2 && r<=N-2) {
            		sum = paper[r][c] + paper[r][c+1] + paper[r+1][c] + paper[r+1][c+1];
            		res = Math.max(res, sum);
            	}
            	// 'ㄴ' 모양
            	
            	if(r<=N-3 && c<=M-2) {
            		sum = paper[r][c] + paper[r+1][c] + paper[r+2][c] + paper[r+2][c+1];
            		res = Math.max(res, sum);
            		sum = paper[r+2][c] + paper[r][c+1] + paper[r+1][c + 1] + paper[r + 2][c + 1];
            		res = Math.max(res, sum);
            		sum = paper[r][c] + paper[r+1][c] + paper[r+2][c] + paper[r][c + 1];
                    res = Math.max(res, sum);
                    sum = paper[r][c] + paper[r][c+1] + paper[r+1][c+1] + paper[r+2][c + 1];
                	res = Math.max(res, sum);
            	}
                if (r <= N-2 && c <= M-3) {
                	sum = paper[r][c] + paper[r+1][c] + paper[r][c+1] + paper[r][c + 2];
                	res = Math.max(res, sum);
                	sum = paper[r][c] + paper[r+1][c] + paper[r+1][c+1] + paper[r+1][c + 2];
                	res = Math.max(res, sum);
                	sum = paper[r+1][c] + paper[r+1][c+1] + paper[r+1][c+2] + paper[r][c + 2];
                	res = Math.max(res, sum);
                	sum = paper[r][c] + paper[r][c+1] + paper[r][c+2] + paper[r+1][c + 2];
                	res = Math.max(res, sum);
                }
                //z자 막대 모양
                if (r <= N-3 && c <= M-2) {
                	sum = paper[r][c] + paper[r+1][c] + paper[r+1][c+1] + paper[r+2][c + 1];
                	res = Math.max(res, sum);
                	sum = paper[r][c+1] + paper[r+1][c] + paper[r+1][c+1] + paper[r+2][c];
                	res = Math.max(res, sum);
                }
                if (r <= N-3 && c <= M-3) {
                	sum = paper[r][c] + paper[r][c+1] + paper[r+1][c+1] + paper[r+1][c + 2];
                	res = Math.max(res, sum);
                }
                if (r <= N-2 && c <= M-3) {
                	sum = paper[r+1][c] + paper[r][c+1] + paper[r+1][c+1] + paper[r][c + 2];
                	res = Math.max(res, sum);
                }
                
            	// 'ㅗ' 모양 
                if (r >= 1 && c >= 1 && c < M - 1) {
                    sum = paper[r][c] + paper[r-1][c] + paper[r][c-1] + paper[r][c+1];
                    res = Math.max(res, sum);
                }
                // 'ㅜ' 모양
                if (r < N - 1 && c >= 1 && c < M - 1) {
                    sum = paper[r][c] + paper[r+1][c] + paper[r][c-1] + paper[r][c+1];
                    res = Math.max(res, sum);
                }
                // 'ㅓ' 모양
                if (r >= 1 && r < N - 1 && c >= 1) {
                    sum = paper[r][c] + paper[r-1][c] + paper[r+1][c] + paper[r][c-1];
                    res = Math.max(res, sum);
                }
                // 'ㅏ' 모양
                if (r >= 1 && r < N - 1 && c < M - 1) {
                    sum = paper[r][c] + paper[r-1][c] + paper[r+1][c] + paper[r][c+1];
                    res = Math.max(res, sum);
                }
            }
        }
        System.out.println(res);
    }
}
