package s0806;

import java.util.Scanner;

public class NM3 {

	static int N;
	static int M;
	static int[] num;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[M];
		visit = new boolean[N+1];
		
		comb(0);
		// 시간초과 -> println 호출은 시간이 많이 걸림 => StringBuilder 사용
		System.out.println(sb);

	}
	static void comb(int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				sb.append(num[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=N;i++) {
			num[idx]=i;
			comb(idx+1);
		}
	}
}
