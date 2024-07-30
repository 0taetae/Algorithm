package s0713;

import java.util.Scanner;
import java.util.Arrays;

public class Level4_N7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[30];
		Arrays.fill(arr, 0);
		
		for(int i=0;i<28;i++) {
			int n = sc.nextInt();
			arr[n-1]=n;
		}
		for(int j=0;j<30;j++) {
			if(arr[j]==0) {
				System.out.println(j+1);
			}
		}
	}

}
