package s09.s0905;

import java.io.*;
import java.util.*;

public class SWEA_5643 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] arr = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				// a는 b보다 작다 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			// 1번은 5번보다 작고, 5번은 4번보다 작다 -> 1번은 4번보다 작다 
			for(int k=0;k<=N;k++) {
				for(int i=0;i<=N;i++) {
					for(int j=0;j<=N;j++) {
						if(arr[i][k]==1 && arr[k][j]==1) {
							arr[i][j]=1;
						}
					}
				}
			}
			int res = 0;
			for(int i=1;i<=N;i++) {
				int cnt =0;
				// i보다 작은 경우 
				for(int j=1;j<=N;j++) {
					if(j==i) continue;
					if(arr[j][i]==1) cnt++;
				}
				// i보다 큰 경우 
				for(int j=1;j<=N;j++) {
					if(arr[i][j]==1) cnt++;
				}
				if(cnt==N-1) {
					res++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
