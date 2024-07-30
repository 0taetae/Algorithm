package s0713;

import java.util.Scanner;

public class Level4_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			int a = sc.nextInt();
			arr[i] = a;
			
		}
		int v = sc.nextInt();
		int sum=0;
		for (int j=0;j<N;j++) {
			if (arr[j]==v) {
				sum=sum+1;
			}
		}
		System.out.println(sum);

	}

}
