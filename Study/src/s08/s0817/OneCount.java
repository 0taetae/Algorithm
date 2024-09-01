package s08.s0817;

import java.util.Scanner;

public class OneCount {
	static long[] F = new long[55];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		
		prefixSum();
		System.out.println(count(B)-count(A-1));

	}
	public static void prefixSum() {
		F[0] = 1;
		
		for(int i=1;i<55;i++) {
			F[i] = (long) F[i-1]*2 + 2^i;
		}
	}
	public static long count(long N) {
		long cnt = 1;
		for(long i=N;i>0;i-=(1<<i)){
			for(long j=54;j>0;j--) {
				cnt += F[(int) (i-1)] + (N-(1<<i)+1);
			}
		}
		return cnt;
	}

}
