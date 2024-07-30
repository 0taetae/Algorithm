package s0713;

import java.util.Scanner;

public class Level4_N4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for(int i=0;i<9;i++) {
			int a = sc.nextInt();
			arr[i] = a;
		}
		int max = arr[0];
		int index = 0;
		for(int j=0;j<9;j++) {
			if(max<arr[j]) {
				max = arr[j];
				index = j;
			}
		}
		System.out.println(max);
		System.out.println(index+1);
		

	}

}
