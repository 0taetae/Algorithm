package s09.s0911;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_9461 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			long N = sc.nextInt();
			long[] dp = new long[101];
			
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			for(int i=5;i<=N;i++) {
				dp[i]= dp[i-5]+dp[i-1];
			}
			System.out.println(dp[(int)N]);
		}
	}

}
