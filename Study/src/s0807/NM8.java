package s0807;

import java.util.Arrays;
import java.util.Scanner;

public class NM8 {

	static int N;
	static int M;
	static int[] num;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		num = new int[M];
		Comb(1, 0);
		System.out.println(sb);
		
	}
	public static void Comb(int start, int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				sb.append(num[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			num[idx]=arr[i];
			Comb(i,idx+1);
		}
	}

}
