package s07.s0714;

import java.util.Scanner;

public class Level8_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = 1;
		int count = 1;
		while(S<N) {
			S+=6*count;
			count+=1;
		}
		System.out.println(count);
		sc.close();

	}

}