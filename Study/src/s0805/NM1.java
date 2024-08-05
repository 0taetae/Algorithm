package s0805;

import java.util.ArrayList;
import java.util.Scanner;

public class NM1 {
	static int N;
	static int M;
	static boolean[] visit;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[M];
		visit = new boolean[N+1];
		
		comb(0);

	}
	static void comb(int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				num[idx]=i;
				comb(idx+1);
				visit[i]=false;
			}
		}
	}
}


