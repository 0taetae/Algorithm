package s09.s0912;

import java.io.*;
import java.util.*;

public class BOJ_11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1]; 
		int[] dp = new int[N+1];
		int res = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int temp = 0;
			arr[i] = Integer.parseInt(st.nextToken());
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);

	}

}
