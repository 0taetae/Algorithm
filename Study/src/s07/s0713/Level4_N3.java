package s07.s0713;

import java.util.Arrays;
import java.util.Scanner;

public class Level4_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			int a = sc.nextInt();
			arr[i] = a;		
		}
		Arrays.sort(arr);
		System.out.println(arr[0]+" "+arr[N-1]);

	}

}
