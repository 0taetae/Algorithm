package s09.s0912;

import java.io.*;
import java.util.*;

public class BOJ_1149 {
	
	static int N;
	static int[][] dp;
	static int res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.min(dp[i-1][1]+R, dp[i-1][2] + R);
			dp[i][1] = Math.min(dp[i-1][0]+G, dp[i-1][2] + G);
			dp[i][2] = Math.min(dp[i-1][0]+B, dp[i-1][1] + B);
		}
		res = Math.min(dp[N][0], dp[N][1]);
		res = Math.min(res, dp[N][2]);
		System.out.println(res);

	}
}
