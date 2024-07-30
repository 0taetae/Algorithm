package s0719;

import java.util.Arrays;
import java.util.Scanner;

public class Level13_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			int n = sc.nextInt();
			arr[i]=n;
		}
		Arrays.sort(arr);
		System.out.println(arr[N-k]);

	}

}
