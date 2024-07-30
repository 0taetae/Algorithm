package s0713;

import java.util.Scanner;

public class Level4_N2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			if(a<X) {
				System.out.print(a+" ");
			}
		}
	}

}
