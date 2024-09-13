package s09.s0913;

import java.io.*;
import java.util.*;

public class BOJ_1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
			}
		}
		int res = 0;
		for(int i=1;i<=N;i++) {
			res = Math.max(res, dp[N][i]);
		}
		System.out.println(res);

	}

}
