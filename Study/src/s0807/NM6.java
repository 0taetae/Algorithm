package s0807;

import java.util.Arrays;
import java.util.Scanner;

public class NM6 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		num = new int[M];
		visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		Comb(1,0);
		

	}
	public static void Comb(int start,int idx) {
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
				num[idx]=arr[i];
				Comb(i+1,idx+1);
				visit[i]=false;
			}
		}
	}

}
