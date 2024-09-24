package s09.s0924;

import java.io.*;
import java.util.*;

public class BOJ_14500 {
    
    static int N, M, res;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (c <= M - 4) { // |모양
                    int sum = paper[r][c] + paper[r][c + 1] + paper[r][c + 2] + paper[r][c + 3];
                    res = Math.max(res, sum);
                }
                if (r <= N - 4) { // - 모양
                    int sum = paper[r][c] + paper[r + 1][c] + paper[r + 2][c] + paper[r + 3][c];
                    res = Math.max(res, sum);
                }
                if (c <= M - 2 && r <= N - 2) {  // ㅁ 모양
                    int sum = paper[r][c] + paper[r][c + 1] + paper[r + 1][c] + paper[r + 1][c + 1];
                    res = Math.max(res, sum);
                }
                if (r <= N - 3 && c <= M - 2) { 
                    int sum1 = paper[r][c] + paper[r + 1][c] + paper[r + 2][c] + paper[r + 2][c + 1];
                    int sum2 = paper[r+2][c] + paper[r][c + 1] + paper[r + 1][c + 1] + paper[r + 2][c + 1];
                    res = Math.max(res, Math.max(sum1, sum2));
                }
                if (r <= N - 2 && c <= M - 3) { 
                    int sum1 = paper[r][c] + paper[r][c + 1] + paper[r][c + 2] + paper[r + 1][c + 2];
                    int sum2 = paper[r + 1][c] + paper[r][c] + paper[r][c + 1] + paper[r][c + 2];
                    res = Math.max(res, Math.max(sum1, sum2));
                }
                if(r<=N-3 && c<=M-2) {
                	int sum1 = paper[r][c] + paper[r][c+1]+paper[r+1][c+1]+paper[r+2][c+1];
                	int sum2 = paper[r][c] + paper[r+1][c] + paper[r+2][c] + paper[r][c+1];
                	res = Math.max(res, Math.max(sum1, sum2));
                }
                if(r>=1 && c<=M-3) {
                	int sum = paper[r][c] + paper[r][c+1] + paper[r][c+2]+paper[r-1][c+2];
                	res = Math.max(res, sum);
                }
                if(r<=N-2 && c<=M-3) {
                	int sum = paper[r][c] + paper[r+1][c] + paper[r+1][c+1]+paper[r+1][c+2];
                	res = Math.max(res, sum);
                }
                if (r >= 1 && c >= 1 && c <= M - 2) {  // ㅗ 모양
                    int sum = paper[r][c] + paper[r - 1][c] + paper[r][c - 1] + paper[r][c + 1];
                    res = Math.max(res, sum);
                }
                if (r <= N - 2 && c >= 1 && c <= M - 2) {  // ㅜ 모양
                    int sum = paper[r][c] + paper[r + 1][c] + paper[r][c - 1] + paper[r][c + 1];
                    res = Math.max(res, sum);
                }
                if (r >= 1 && r < N - 1 && c >= 1) {  // ㅓ 모양
                    int sum = paper[r][c] + paper[r - 1][c] + paper[r + 1][c] + paper[r][c - 1];
                    res = Math.max(res, sum);
                }
                if (r >= 1 && r < N - 1 && c < M - 1) {  // ㅏ 모양
                    int sum = paper[r][c] + paper[r - 1][c] + paper[r + 1][c] + paper[r][c + 1];
                    res = Math.max(res, sum);
                }
                if (r<=N-3 && c<=M-2) {
                	int sum = paper[r][c] + paper[r+1][c]+paper[r+1][c+1]+paper[r+2][c+1];
                	res = Math.max(res,sum);
                }
                if(c>=1 && r<=N-2 && c<=M-2) {
                	int sum = paper[r][c] + paper[r+1][c-1] + paper[r][c+1] + paper[r+1][c];
                	res = Math.max(res, sum);
                }
                if(c>=1 && r<= N-3) {
                	int sum = paper[r][c] + paper[r+1][c] + paper[r+1][c-1] + paper[r+2][c-1];
                	res = Math.max(res,sum);
                }
                if(r<=N-2 && c<=M-3) {
                	int sum = paper[r][c] + paper[r][c+1]+ paper[r+1][c+1]+ paper[r+1][c+2];
                	res = Math.max(res, sum);
                }
            }
        }
        System.out.println(res);
    }
}

