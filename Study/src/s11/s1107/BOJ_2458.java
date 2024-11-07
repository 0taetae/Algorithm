package s11.s1107;

import java.io.*;
import java.util.*;

public class BOJ_2458 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] low = new boolean[N+1][N+1];  // 자신보다 키 작은 사람 표시
		boolean[][] height = new boolean[N+1][N+1];  // 자신보다 키 큰 사람 표시
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			low[b][a] = true;
			height[a][b] = true;
		}
		
		// 자신보다 키 작은 사람
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(low[i][k] && low[k][j]) {
						low[i][j] = true;
					}
				}
			}
		}
		
		// 자신보다 키 큰 사람
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(height[i][k] && height[k][j]) {
						height[i][j] = true;
					}
				}
			}
		}
		int res=0;
		for(int i=1;i<=N;i++) {
			int ans=0;
			for(int j=1;j<=N;j++) {
				if(low[i][j]) {
					ans++;
				}
				if(height[i][j]) {
					ans++;
				}
			}
			if(ans==N-1) {
				res++;
			}
		}
		System.out.println(res);

	}

}
