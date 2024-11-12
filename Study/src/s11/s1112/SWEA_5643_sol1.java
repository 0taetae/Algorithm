package s11.s1112;

import java.io.*;
import java.util.*;

// sol 1. 플로이드워샬
public class SWEA_5643_sol1 {
	
	static int N,M;
	static boolean[][] Short;
	static boolean[][] Long;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());  // 학생들의 수
			M = Integer.parseInt(br.readLine());  // 두 학생 키를 비교한 횟수
			
			Short = new boolean[N+1][N+1];  // 자신 보다 작은 사람 
			Long = new boolean[N+1][N+1];  // 자신 보다 큰 사람
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());  // 작은 사람
				int b = Integer.parseInt(st.nextToken());  // 큰 사람
				Long[a][b] = true;
				Short[b][a] = true;
			}
			
			// 플로이드 워셜 알고리즘으로 자신보다 작은 사람, 큰 사람 모두 구하기 
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(Long[i][k] && Long[k][j]) {
							Long[i][j] = true;
						}
						if(Short[i][k] && Short[k][j]) {
							Short[i][j] = true;
						}
					}
				}
			}
			int res=0;
			for(int i=1;i<=N;i++) {
				int sum=0;
				for(int j=1;j<=N;j++) {
					if(Long[i][j]) {
						sum++;
					}
					if(Short[i][j]) {
						sum++;
					}
				}
				if(sum==N-1) {
					res++;
				}
			}
			System.out.println("#"+tc+" "+res);
		}

	}

}
