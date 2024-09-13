package s09.s0913;

import java.io.*;
import java.util.*;

public class BOJ_9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][N+2];
			int[][] dp = new int[2][N+2];
			for(int j=0;j<2;j++) {
				st = new StringTokenizer(br.readLine());
				for(int i=2;i<=N+1;i++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=2;i<=N+1;i++) {
				dp[0][i] = Math.max(dp[0][i-2]+arr[0][i], dp[1][i-2]+arr[0][i]);
				dp[0][i] = Math.max(dp[0][i], dp[1][i-1]+arr[0][i]);
				//System.out.println("0, "+i+" "+dp[0][i]);
				
				dp[1][i] = Math.max(dp[0][i-2]+arr[1][i], dp[1][i-2]+arr[1][i]);
				dp[1][i] = Math.max(dp[1][i], dp[0][i-1]+arr[1][i]);
				//System.out.println("1, "+i+" "+dp[1][i]);
			}
			System.out.println(Math.max(dp[0][N+1], dp[1][N+1]));
		}
	}
}
