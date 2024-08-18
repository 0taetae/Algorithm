package s07.s0714;

import java.util.Scanner;

public class Level8_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num = 0;
		int[] arr = {25, 10, 5, 1};
		for(int i=0;i<T;i++) {
			int C = sc.nextInt();
			for(int j=0;j<4;j++) {
				num = C / arr[j];
				System.out.print(num+" ");
				C = C - num*arr[j];
			}
			System.out.println();
		}
		sc.close();

	}

}
