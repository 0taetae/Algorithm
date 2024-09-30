package s09.s0930;

import java.io.*;
import java.util.*;

public class SWEA_3282 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); 
			
			int[][] dp = new int[N+1][K+1];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				int W = Integer.parseInt(st.nextToken()); 
				int V = Integer.parseInt(st.nextToken()); 
				
				if(W<=K) {
					for(int j=0;j<W;j++) {
						dp[i][j] = dp[i-1][j];
					}
					for(int j=W;j<=K;j++) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W]+V);
					}
				}else {
					for(int j=0;j<=K;j++) {
						dp[i][j] = dp[i-1][j];
					}
				}
				
			}
			System.out.println("#"+tc+" "+dp[N][K]);
		}
	}


}
