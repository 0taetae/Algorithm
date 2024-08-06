package s0806;

import java.util.Scanner;

public class NM1 {
	static int M;
	static int N;
	static boolean visit[];
	static int num[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new boolean[N+1];
		num = new int[M];
		
		Com(0);
		

	}
	static void Com(int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					visit[i]=true;
					num[idx]=i;
					Com(idx+1);
					visit[i]=false;
				}
			}
		}
	}

}
