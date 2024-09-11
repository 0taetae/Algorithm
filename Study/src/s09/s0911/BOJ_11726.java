package s09.s0911;

import java.util.Scanner;

public class BOJ_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long[] dp = new long[(int) (N+1)];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=N;i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[(int)N]);
		

	}

}
