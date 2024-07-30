package s0713;

import java.util.Scanner;

public class Level4_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int k=0;k<N;k++) {
			arr[k]=k+1;
		}
		for(int r=0;r<M;r++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int temp;
			temp = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = temp;
		}
		for(int s=0;s<N;s++) {
			System.out.print(arr[s]+" ");
		}

	}

}
