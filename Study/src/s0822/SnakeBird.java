package s0822;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeBird {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			if(L>=arr[i]) {
				L++;
			}
		}
		System.out.println(L);

	}

}