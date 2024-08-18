package s07.s0713;

import java.util.Scanner;

public class Level4_N9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int k=0;k<N;k++) {
			arr[k]=k+1;
		}
		for (int r=0;r<M;r++) {
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			while(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		for(int v=0;v<N;v++) {
			System.out.print(arr[v]+" ");
		}

	}

}
