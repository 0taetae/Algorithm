package s0713;

import java.util.Scanner;
import java.util.Arrays;

public class Level4_N10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		double sum=0;
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			arr[i]=a;
			sum=sum+a;
		}
		Arrays.sort(arr);
		System.out.println((sum*100/arr[N-1])/N);

	}

}
