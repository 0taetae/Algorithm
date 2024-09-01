package s08.s0806;

import java.util.Scanner;

public class NM4 {

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
		
		comb(1, 0);
		
		System.out.println(sb);

	}
	static void comb(int start, int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				sb.append(num[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			num[idx]=i;
			comb(i,idx+1);
		}
	}

}
