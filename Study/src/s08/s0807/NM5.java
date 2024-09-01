package s08.s0807;

import java.util.Arrays;
import java.util.Scanner;

public class NM5 {
	static int[] arr ;
	static int[] num;
	static boolean[] visit;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		num = new int[M];
		visit = new boolean[N+1];
		
		Comb(0);
		

	}
	public static void Comb(int idx) {
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
				num[idx]=arr[i];
				Comb(idx+1);
				visit[i]=false;
			}
		}
	}

}
