package s08.s0806;

import java.util.Scanner;

public class NM2 {
	static boolean visit[];
	static int num[];
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new boolean[N+1];
		num = new int[M];
		
		Comb(1, 0);

	}
	public static void Comb(int start, int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {  // 두번째 수는 첫번째 수보다 큰 수만
			if(!visit[i]) {
				visit[i]=true;
				num[idx]=i;
				Comb(i+1,idx+1);
				visit[i]=false;
			}
		}
	}

}
