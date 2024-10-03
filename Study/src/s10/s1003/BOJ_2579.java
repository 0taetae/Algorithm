package s10.s1003;

import java.io.*;
import java.util.*;

public class BOJ_2579 {
	/*
	한번에 한 계단씩 또는 두 계단씩 오를 수 있음
	연속된 세 개의 계단을 모두 밟으면 안된다.
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = score[1];
		if(N>=2) {
			dp[2] = score[1]+score[2];
		}
		if(N>=3) {
			dp[3] = Math.max(score[1]+score[3],score[2]+score[3]);
		}
		for(int i=4;i<=N;i++) {
			dp[i] = Math.max(dp[i-2]+score[i], dp[i-3]+score[i-1]+score[i]);
		}
		System.out.println(dp[N]);

	}

}
