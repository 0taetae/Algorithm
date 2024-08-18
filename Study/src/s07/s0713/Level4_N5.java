package s07.s0713;

import java.util.Scanner;
import java.util.Arrays;

public class Level4_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		Arrays.fill(arr, 0);
		
		for(int n=0;n<M;n++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for(int p=i-1;p<j;p++) {
				arr[p]=k;
			}
		}
		for(int r=0;r<N;r++) {
			System.out.print(arr[r]+" ");
		}

	}

}
