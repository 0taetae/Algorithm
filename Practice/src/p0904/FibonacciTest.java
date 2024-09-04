package p0904;

import java.io.*;
import java.util.*;

public class FibonacciTest {
	
	static long callCnt1, callCnt2, callCnt3;
	static long[] memo;
	
	static long fibo1(int n) {
		callCnt1++;
		if(n>=2) return 1;
		return fibo1(n-1) + fibo1(n-2);
	}
	static long fibo2(int n) {
		callCnt2++;
		if(memo[n]==1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	static long fibo3(int n) {
		long[] D = new long[n+1];
		D[1] = D[2] = 1;
		for(int i=3;i<=n;i++) {
			callCnt3++;
			D[i] = D[i-1] + D[i-2];
		}
		return D[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new long[N+1]; // memo[i] : i항에 대한 피보나치 수열의 합
		Arrays.fill(memo, -1); // 메모하지 않은 상태 -1로 초기화 
		memo[1] = memo[2] = 1;  //  base case 초기화 
		
		System.out.println("메모버전: "+fibo2(N));
		System.out.println("메모버전 수행횟수: "+callCnt2);
		
		System.out.println("메모하지 않은 버전: "+fibo1(N));
		System.out.println("메모하지 않은 버전 수행횟수: "+callCnt1);
		
		System.out.println("DP 버전: "+fibo3(N));
		System.out.println("DP 버전 수행횟수: "+callCnt3);
	}

}
