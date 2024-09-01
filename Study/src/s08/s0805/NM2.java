package s08.s0805;

import java.util.Scanner;

public class NM2 {
	static int N;
	static int M;
	static int[] num;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[M];
		visit = new boolean[N+1];
		
		comb(1,0);

	}
	static void comb(int start, int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				num[idx]=i;
				comb(i+1, idx+1);
				visit[i]=false;
			}
		}
	}

}
